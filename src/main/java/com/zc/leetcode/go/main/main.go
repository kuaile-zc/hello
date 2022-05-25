package main

import (
	"sort"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	//minMoves2([]int{1,2,3,100,5,9})
	println(canIWin(10, 0))
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

func abs(a, b int) int {
	if a > b {
		return a - b
	}
	return b - a
}

// https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
func repeatedNTimes(nums []int) int {
	dataMap := make(map[int]bool)
	for _, num := range nums {
		if dataMap[num] {
			return num
		}
		dataMap[num] = true
	}
	return -1
}

var memery = map[int]bool{}

// https://leetcode.cn/problems/can-i-win/
func canIWin(maxChoosableInteger int, desiredTotal int) bool {
	if desiredTotal > (maxChoosableInteger+1)*maxChoosableInteger/2 {
		return false
	}
	return dfs(0, 0, maxChoosableInteger, desiredTotal)
}

func dfs(numPool, curTotal, length, desiredTotal int) bool {
	if _, isExist := memery[numPool]; !isExist {
		result := false
		for i := 0; i < length; i++ {
			if (numPool>>i)&1 == 0 {
				if curTotal+i+1 >= desiredTotal {
					result = true
					break
				}
				if !dfs(numPool|(1<<i), curTotal+i+1, length, desiredTotal) {
					result = true
					break
				}
			}
		}
		memery[numPool] = result
	}
	return memery[numPool]
}

func isUnivalTree(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if root.Left != nil && root.Val != root.Left.Val {
		return false
	}
	if root.Right != nil && root.Val != root.Right.Val {
		return false
	}
	return isUnivalTree(root.Right) && isUnivalTree(root.Left)
}

// https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
func findSubstringInWraproundString(p string) (ans int) {
	var dp [26]int
	k := 0
	for i := 0; i < len(p); i++ {
		if i > 0 && (p[i]-p[i-1]+26)%26 == 1 {
			k++
		} else {
			k = 1
		}
		dp[p[i]-'a'] = max(dp[p[i]-'a'], k)
	}
	for _, v := range dp {
		ans += v
	}
	return
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
