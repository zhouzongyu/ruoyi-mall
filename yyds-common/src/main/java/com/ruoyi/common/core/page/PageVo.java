package com.ruoyi.common.core.page;

import lombok.Data;

import java.util.List;
@Data
public class PageVo<T> {
  private long total;
  private long size;
  private long current;
  private long pages;
  private List<T> records;
}
