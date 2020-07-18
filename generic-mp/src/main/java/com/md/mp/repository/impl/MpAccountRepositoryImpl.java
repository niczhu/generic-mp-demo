package com.md.mp.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.mapper.MpAccountMapper;
import com.md.mp.dal.vo.MpAccountVo;
import com.md.mp.framwork.base.repository.AbstractRepository;
import com.md.mp.framwork.utils.ConverterUtil;
import com.md.mp.repository.MpAccountRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * MpAccountRepositoryImpl
 *
 * @author zhuhaipeng6 in 2020/5/11 14:43
 * @version 1.0
 **/
@Repository
public class MpAccountRepositoryImpl extends AbstractRepository<MpAccountMapper, MpAccountBean, MpAccountVo> implements MpAccountRepository {

    @Autowired
    private MpAccountMapper mpAccountMapper;

    @Transactional(readOnly = true)
    @Override
    public MpAccountVo getVoById(Integer id) {
        // TODO: 参数合法性检验
        MpAccountBean bean = getById(id);
        return ConverterUtil.objConvert(MpAccountVo.class, bean);
    }

    @Transactional(readOnly = true)
    @Override
    public Page page(MpAccountVo vo) {
        QueryWrapper<MpAccountBean> wrapper = baseWhereCondition(vo);
        Page<MpAccountBean> queryPage = new Page<>(vo.getCurrentPage(), vo.getPageSize());

        Page<MpAccountBean> beanPage = (Page<MpAccountBean>) mpAccountMapper.selectPage(queryPage, wrapper);

        Page<MpAccountVo> voPage = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        return voPage.setRecords(ConverterUtil.objConvertList(MpAccountVo.class, beanPage.getRecords()));
    }

    @Transactional(readOnly = true)
    @Override
    public List<MpAccountVo> search(MpAccountVo mpAccountVo) {
        // TODO: 参数合法性检验
        QueryWrapper<MpAccountBean> wrapper = whereCondition(mpAccountVo);
        List<MpAccountBean> beanList = mpAccountMapper.selectList(wrapper);

        return ConverterUtil.objConvertList(MpAccountVo.class, beanList);
    }

    @Override
    public List<MpAccountVo> search(Map<String, Object> queryParams) {
        List<MpAccountBean> beans = mpAccountMapper.searchEntity(queryParams);
        return ConverterUtil.objConvertList(MpAccountVo.class, beans);
    }

    @Override
    public long countByVo(MpAccountVo accountVo) {
        QueryWrapper<MpAccountBean> wrapper = whereCondition(accountVo);
        return count(wrapper);
    }

    @Override
    @Transactional
    public MpAccountVo saveUpdateVo(MpAccountVo accountVo) {
        // TODO: 参数合法性检验
        //TODO 初始化属性值
        MpAccountBean bean = ConverterUtil.objConvert(MpAccountBean.class, accountVo);
        boolean b = saveOrUpdate(bean);
        if (b && null != bean) {
            accountVo.setId(bean.getId());
            return accountVo;
        }
        return null;
    }

    @Override
    public boolean SaveUpdateBatchVo(List<MpAccountVo> accountVos) {
        // TODO: 参数合法性检验
        return saveOrUpdateBatch(ConverterUtil.objConvertList(MpAccountBean.class, accountVos));
    }

    @Override
    @Transactional
    public boolean deleteVoById(Integer id) {
        return mpAccountMapper.deleteById(id) > 0;
    }

    protected QueryWrapper<MpAccountBean> whereCondition(MpAccountVo vo) {
        QueryWrapper<MpAccountBean> queryWrapper = baseWhereCondition(vo);
        if (null == vo) {
            return queryWrapper;
        }
        // TODO: 查询条件填充

        if (vo.getPageSize() == 0) {
            queryWrapper.last("limit 0 , 10000");
        } else {
            String limit = StringUtils.join("limit ", String.valueOf((int) vo.getCurrentPage()), ",", String.valueOf((int) vo.getPageSize()));
            queryWrapper.last(limit);
        }
        return queryWrapper;
    }

    protected QueryWrapper<MpAccountBean> baseWhereCondition(MpAccountVo vo) {
        QueryWrapper<MpAccountBean> queryWrapper = new QueryWrapper<>();
        if (null == vo) {
            return queryWrapper;
        }
        // TODO: 基本查询条件填充
        queryWrapper.lambda()
                .eq(null != vo.getId(), MpAccountBean::getId, vo.getId())
                .eq(StringUtils.isNotEmpty(vo.getPin()), MpAccountBean::getPin, vo.getPin())
                .eq(StringUtils.isNotEmpty(vo.getName()), MpAccountBean::getName, vo.getName())
                .eq(vo.getAge() > 0, MpAccountBean::getAge, vo.getAge());

        return queryWrapper;
    }


//    private List<MpAccountVo> convertToModels(List<MpAccountBean> beans) {
//        if (CollectionUtils.isNotEmpty(beans)) {
//            List<MpAccountVo> modelList = new ArrayList<>();
//            for (MpAccountBean bean : beans) {
//                MpAccountVo model = this.objConvert(MpAccountVo.class, bean);
//                modelList.add(model);
//            }
//            return modelList;
//        }
//        return Collections.emptyList();
//    }
//
//    private List<MpAccountBean> convertToBeans(List<MpAccountVo> models) {
//        if (CollectionUtils.isNotEmpty(models)) {
//            List<MpAccountBean> beanList = new ArrayList<>();
//            for (MpAccountVo model : models) {
//                beanList.add(this.objConvert(MpAccountBean.class, model));
//            }
//            return beanList;
//        }
//        return Collections.emptyList();
//    }


}
