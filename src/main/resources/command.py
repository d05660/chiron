#!/usr/bin/env python3
#encoding: utf-8

import os, sys, time
import pika
import json
import subprocess


def get_channel():
    credentials = pika.PlainCredentials('rabbitmq', 'rabbitmq')
    parameters = pika.ConnectionParameters(host='192.168.1.33',
                                           virtual_host='/',
                                           credentials=credentials)
    connection = pika.BlockingConnection(parameters)
    return connection.channel()


def get_ipaddress():
    ip_cmd_str = """
ifconfig -a|grep -o -e 'inet [0-9]\{1,3\}.[0-9]\{1,3\}.[0-9]\{1,3\}.[0-9]\{1,3\}'|
grep -v '127.0.0'|awk '{print $2}'"""
    ret1=subprocess.check_output([ip_cmd_str], shell=True)
    return ret1.decode('ascii').strip('\n')


def ipCommandSender():
    channel = get_channel()
    channel.queue_declare(queue="local.command.queue.receiver", durable=True)
    mess = {'command':get_ipaddress(), 'date': time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())}
    print(mess)
    message = json.dumps(mess)
    channel.basic_publish(exchange='local.command.exchange',
                          routing_key='local.command.routing.key.receiver',
                          body=message,
                          properties=pika.BasicProperties(
                              content_type='application/json',
                              content_encoding='utf-8',
                              delivery_mode=2
                          ))
    print('send message: %s' %  message)
    channel.close()


def Main():
    channel = get_channel()
    channel.queue_declare(queue='local.command.queue.sender', durable=True)
    channel.basic_consume('local.command.queue.sender',
                          callback,
                          auto_ack=True)
    channel.start_consuming()


def callback(ch, method, properties, body):
    print(" [x] %r:%r" % (method.routing_key, body))
    print(body)
    commander = json.loads(body)
    print(commander)
    if commander['command'] == 'ip':
        ipCommandSender()


if __name__ == '__main__':
    Main()
