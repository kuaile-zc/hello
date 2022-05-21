package main

import "sort"

func main() {
	minMoves2([]int{1,2,3,100,5,9})
}

//
func minMoves2(nums []int) int {
	sort.Ints(nums)
	var med = nums[len(nums)/2]
	var result = 0
	for _, n := range nums {
		result += abs(n, med)
	}
	return result
}

func abs(a,b int) int {
	if a > b {
		return a-b
	}
	return b-a
}

// https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
func repeatedNTimes(nums []int) int {
	dataMap := make(map[int]bool)
	for _ ,num := range nums {
		if  dataMap[num]{
			return num
		}
		dataMap[num] = true
	}
	return -1
}
