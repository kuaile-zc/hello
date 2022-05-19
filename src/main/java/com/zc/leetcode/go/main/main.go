package main

import "sort"

func main() {
	minMoves2([]int{1,2,3,100,5,9})
}

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
