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
	//println(canIWin(10, 0))
	//findClosest([]string{"I","am","a","student","from","a","university","in","a","city"}, "a","student" )
	removeOuterParentheses("(()())(())")
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

func findClosest(words []string, word1 string, word2 string) int {
	index := [2]int{-1, -1}
	result := len(words)
	for idx, str := range words {
		if str != word1 && str != word2 {
			continue
		} else if str == word1 {
			index[0] = idx
		} else {
			index[1] = idx
		}

		if index[0] != -1 && index[1] != -1 {
			result = min(result, abs(index[0], index[1]))
		}
	}
	return result
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

// https://leetcode.cn/problems/remove-outermost-parentheses/
func removeOuterParentheses(s string) string {
	var result []rune
	curBracketNum := 0
	for _, c := range s {
		if c == ')' {
			curBracketNum--
		}
		if curBracketNum > 0 {
			result = append(result, c)
		}
		if c == '(' {
			curBracketNum++
		}
	}
	return string(result)
}

// https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
func sumRootToLeaf(root *TreeNode) int {
	return dfs2(root, 0)
}

func dfs2(root *TreeNode, value int) int {
	if root == nil {
		return 0
	}
	value = value<<1 | root.Val
	if root.Right == nil && root.Left == nil {
		return value
	}
	return dfs2(root.Left, value) + dfs2(root.Right, value)
}
