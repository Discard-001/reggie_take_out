package cn.hjk.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.hjk.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
