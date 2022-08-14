package com.tianlisir.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianlisir.entity.Starter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Another
 * @since 2022/08/14
 */
@Mapper
public interface StarterDao extends BaseMapper<Starter> {
    List<Starter> getDelete();
}
