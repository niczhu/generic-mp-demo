package com.md.mp.web.controller;

import com.md.mp.dal.vo.MpAccountVo;
import com.md.mp.framwork.base.web.BaseController;
import com.md.mp.framwork.utils.ConverterUtil;
import com.md.mp.repository.MpAccountRepository;
import com.md.mp.service.MpAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * MpAccountController
 *
 * @author zhuhaipeng6 in 2020/7/15 17:21
 * @version 1.0
 **/
@RestController
@RequestMapping("/mpAccount")
public class MpAccountController extends BaseController {
    @Autowired
    private MpAccountService mpAccountService;

    @Autowired
    private MpAccountRepository mpAccountRepository;

    /**
     * 根据id查看AccountModel <br>
     * <b>GET /account/{id}.htm</b> <br>
     * 必填参数： <br>
     * 可选参数： <br>
     * 返回值：AccountModel详情页面
     *
     * @param id 查询数据id
     * @return 详情页面模板
     */
    @GetMapping(value = "{id}")
    public MpAccountVo queryById(@PathVariable Integer id) {
        if (null == id) {
            // todo:
        }
        MpAccountVo vo = mpAccountRepository.getVoById(id);
        return vo;
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody MpAccountVo mpAccountVo) {
        // TODO: 1.数据有效性校验
        return mpAccountRepository.saveUpdateVo(mpAccountVo);
    }

    @GetMapping(value = "delete/{id}")
    public Object delete(@PathVariable int id) {
        // TODO: 1.数据有效性校验
        return mpAccountRepository.deleteVoById(id);
    }

    @PostMapping(value = "page")
    public Object page(@RequestBody MpAccountVo vo) {
        // TODO: 1.数据有效性校验
        return  mpAccountRepository.page(vo);
    }

}
