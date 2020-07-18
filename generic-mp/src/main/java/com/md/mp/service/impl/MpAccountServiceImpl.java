package com.md.mp.service.impl;

import com.md.mp.repository.MpAccountRepository;
import com.md.mp.service.MpAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MpAccountServiceImpl
 *
 * @author zhuhaipeng6 in 2020/7/15 16:34
 * @version 1.0
 **/
@Service
public class MpAccountServiceImpl implements MpAccountService {

    @Autowired
    private MpAccountRepository mpAccountRepository;

}
