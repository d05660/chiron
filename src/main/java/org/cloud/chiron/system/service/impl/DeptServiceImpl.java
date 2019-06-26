package org.cloud.chiron.system.service.impl;

import org.cloud.chiron.common.base.BaseServiceImpl;
import org.cloud.chiron.system.mapper.DeptMapper;
import org.cloud.chiron.system.model.Dept;
import org.cloud.chiron.system.service.IDeptService;
import org.springframework.stereotype.Service;

@Service("deptService")
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, Dept> implements IDeptService {

}
