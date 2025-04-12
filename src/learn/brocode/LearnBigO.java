package learn.brocode;

public class LearnBigO {
	public static void main(String[] args) {
		/*
		O(1) 				= constant time
		O(log n) 		= logarithmic time
		O(n) 				= linear time
		O(n log n) 	= quasilinear time	
		O(n^2) 			= quadratic time
		O(n!)				= factorial time

		EXCEPTIONS TO BIG O (applicable for small data sets)
		> hardware perspective
			- spacial and temporal locality of data access (CPU pre-loads into caches)
			- CPU performs branch prediction (which favours simpler logic)
			- SIMD optimisations favour contiguous data and uniform/predictable operations
		> software perspective
			- think about overhead of algorithm (function call, setup cost, memory allocation)
				i.e. different sorts OR recursion OR linear vs binary search
			- think about memory access patterns (contiguous for spacial, uniformity and simplicity for temporal)
			- think about in-place vs new memory allocation
			- think about algorithmic complexity (branch prediction and SIMD optimisations)
		*/	
	}
}