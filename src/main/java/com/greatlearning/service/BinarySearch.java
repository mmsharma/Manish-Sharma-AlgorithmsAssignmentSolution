package com.greatlearning.service;

import com.greatlearning.model.Company;

public class BinarySearch {

	public int binarySearch(Company arr[], int left, int right, double stockPriceToSearch) {
		if (right >= left) {
			int mid = left + (right - left) / 2;

			if (arr[mid].getStockPrice() == stockPriceToSearch)
				return mid;
			if (arr[mid].getStockPrice() < stockPriceToSearch)
				return binarySearch(arr, left, mid - 1, stockPriceToSearch);

			return binarySearch(arr, mid + 1, right, stockPriceToSearch);
		}
		return -1;
	}
}
