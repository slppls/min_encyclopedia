package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.CountersMapper;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {

  @Override
  public Optional<Counter> getCounter(Integer id) {
    return Optional.ofNullable(null);
  }

  @Override
  public void upsertCount(Counter counter) {
    return;
  }

  @Override
  public void clearCount(Integer id) {
    return;
  }
}
