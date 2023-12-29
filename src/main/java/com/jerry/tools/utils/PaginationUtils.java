package com.jerry.tools.utils;

import java.util.ArrayList;
import java.util.List;

/**** 
 * @description: List手动分页
 * @param: null
 * @return:
 * @author Jerry
 * @date: 2023-9-27 19:49
 */
public class PaginationUtils<T> {
	public List<T> getPageData(List<T> dataList, int pageNumber, int pageSize) {
		int totalCount = dataList.size();
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);

		int fromIndex = (pageNumber - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, totalCount);
		if (fromIndex > toIndex) {
			return new ArrayList<>();
		}
		List<T> pageData = new ArrayList<>(dataList.subList(fromIndex, toIndex));

		return pageData;
	}

	public int getTotalCount(List<T> dataList) {
		return dataList.size();
	}

	public int getTotalPages(List<T> dataList, int pageSize) {
		int totalCount = dataList.size();
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		return totalPages;
	}

/*  用法
	PaginationUtils<CourseVO> paginationUtils = new PaginationUtils<>();

	// 获取分页数据
	List<CourseVO> pageData = paginationUtils.getPageData(courseVOList, pageHelper.getPage(), pageHelper.getSize());

	// 获取总数
	int totalCount = paginationUtils.getTotalCount(courseVOList);

	// 获取总页数
	int totalPages = paginationUtils.getTotalPages(courseVOList, pageHelper.getSize());

        System.out.println("页码: " + pageHelper.getPage());
        System.out.println("总数: " + totalCount);
        System.out.println("分页后的数据: " + pageData);
        System.out.println("总页数: " + totalPages);*/
}