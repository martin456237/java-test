package com.java.test.arithmetric.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 快手面试题： 推荐结果打算
 */
public class KuaiShouExGetResult {

  /**
   *
   * @param picAndVedioList  短视屏和图片的混合结果
   * @param minInerval 两个图片之间 至少要间隔多少个短视屏
   * @return
   */
  private List<String> getRecommendResult(List<String> picAndVedioList, int minInerval) {
    // 最终结果
    List<String> result = new ArrayList<>();
    if (null == picAndVedioList || picAndVedioList.size() == 0) {
      return result;
    }
    // video list
    Queue<String> videoQueue = new LinkedList<>();
    // pic list
    Queue<String> picQueue = new LinkedList<>();


    int index = 0;
    while (index < picAndVedioList.size() && !isPic(picAndVedioList.get(index))) {
      result.add(picAndVedioList.get(index));
      index++;
    }
    while (index < picAndVedioList.size()) {
      String item = picAndVedioList.get(index);
      if (isPic(item)) {
        picQueue.add(item);
      } else {
        videoQueue.add(item);
      }
      index++;
    }

    int current = result.size();
    while (videoQueue.size() > 0 && picQueue.size() > 0) {
      if (current >= minInerval) {
        result.add(picQueue.poll());
        current = 0;
      } else {
        result.add(videoQueue.poll());
        current++;
      }
    }
    while (videoQueue.size() > 0) {
      result.add(videoQueue.poll());
    }
    if(current < minInerval && picQueue.size() > 0) {
      result.add(picQueue.poll());
    }
    return result;
  }

  private boolean isPic(String item) {
    if (item.startsWith("v")) {
      return false;
    }
    return true;
  }
}
