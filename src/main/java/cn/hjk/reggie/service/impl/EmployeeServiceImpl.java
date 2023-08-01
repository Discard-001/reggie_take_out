package cn.hjk.reggie.service.impl;

import cn.hjk.reggie.entity.Employee;
import cn.hjk.reggie.mapper.EmployeeMapper;
import cn.hjk.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
