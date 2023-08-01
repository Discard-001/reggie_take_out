package cn.hjk.reggie.service.impl;

import cn.hjk.reggie.mapper.AddressBookMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hjk.reggie.entity.AddressBook;
import cn.hjk.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
