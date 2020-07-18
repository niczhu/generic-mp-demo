package com.md.mp.repository;

import com.alibaba.fastjson.JSON;
import com.md.mp.BaseTest;
import com.md.mp.dal.vo.MpAccountVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MpAccountRepositoryTest extends BaseTest {

    @Autowired
    private MpAccountRepository mpAccountRepository;

    @Test
    public void testSearch() {
//        MpAccountVo mpAccountVo = new MpAccountVo();
//        mpAccountVo.setPin("pin1");
////        mpAccountVo.setAge(10);
//        List<MpAccountVo> search = mpAccountRepository.search(mpAccountVo);
//        System.out.println(JSON.toJSONString(search.size()));

        Map<String, Object> params = new HashMap<>();
        params.put("pin","pin2");
        params.put("age",0);
        List<MpAccountVo> search1 = mpAccountRepository.search(params);
        System.out.println(JSON.toJSONString(search1.size()));
    }

    @Test
    public void testGetById() {
        Integer id = 44;
        MpAccountVo voById = mpAccountRepository.getVoById(id);
        System.out.println(voById);
    }

    @Test
    public void testCountByVo(){
        MpAccountVo mpAccountVo = new MpAccountVo();
        mpAccountVo.setPin("pin1");
        long l = mpAccountRepository.countByVo(mpAccountVo);
        System.out.println(l);
    }

    @Test
    public void TestDeleteVo(){
        Integer id = 44;
        boolean b = mpAccountRepository.deleteVoById(id);
        System.out.println(b);
    }

}
