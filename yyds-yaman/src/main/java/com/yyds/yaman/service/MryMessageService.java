package com.yyds.yaman.service;


 import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
 import com.yyds.yaman.domain.MryMessage;
 import com.yyds.yaman.pojo.query.MryMessageQuery;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryMessageMapper;

/**
 * 【请填写功能名称】Service业务层处理
 *
 *
 * @author zzy
 */
@Service
public class MryMessageService {
    @Autowired
    private MryMessageMapper mryMessageMapper;
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MryMessage selectById(Integer id) {
        return mryMessageMapper.selectById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param query 查询条件
     * @param pageNum 分页条件
     * @return 【请填写功能名称】
     */
    public List<MryMessage> selectList(MryMessageQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper<MryMessage> qw = new QueryWrapper<>();
        qw.eq("delete_flag",0);
        String msgTitle = query.getMsgTitle();
        if (!StringUtils.isEmpty(msgTitle)) {
            qw.like("msg_title", msgTitle);
        }
        String msgContent = query.getMsgContent();
        if (!StringUtils.isEmpty(msgContent)) {
            qw.eq("msg_content", msgContent);
        }

        return mryMessageMapper.selectList(qw);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param mryMessage 【请填写功能名称】
     * @return 结果
     */
    public int insert(MryMessage mryMessage) {
        mryMessage.setDeleteFlag(0);
        mryMessage.setCreateTime(LocalDateTime.now());
        return mryMessageMapper.insert(mryMessage);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param mryMessage 【请填写功能名称】
     * @return 结果
     */
    public int update(MryMessage mryMessage) {
        return mryMessageMapper.updateById(mryMessage);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    public int deleteByIds(Integer[] ids) {
        return mryMessageMapper.updateDelFlagByIds(ids);
    }


}
