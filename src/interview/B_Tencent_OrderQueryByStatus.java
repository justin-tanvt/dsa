package interview;

public class B_Tencent_OrderQueryByStatus {
  public static void main(String[] args) {
    // order processing system
    // order
    // autoID - (i.e. 1)
      // long
    // order ID
      // first 4 digit - YYYY (i.e. 2025)
      // random fixed-length-string
    // status (mandatory)
        // int - (i.e. 1)
    // createTime
      // fixed-length-String


    // getAllOrder(int status)

    // helper methods
    // getShardKeys()
    // getOrdersForYear(int year)
    // getOrdersForYear(int pageNumber, int pageSize, int status)   // ensure sorted
    // getOrderCountForYear(int year)

    // getPagedOrder(int pageNumber, int pageSize, int status)
    // getShardKeys
    // recordNumber = 0
    // loop through shard keys
      // get order count for that year
      // int currentPageNo = 0;
      // while orderCount > 0
        // currentPageNo++
        // getOrdersForYear(currentPageNo, pageSize, status)

    // ordering (within the year) - should be the same

    // test cases
    // 1. ensure that all records are of correct status
    // 2. ensure pageSize within expected [0, pageSize]
    // 3. ensure that duplicate records across different pages
    // 4. after merging pages, ensure that ordering is the same --> simulate 2 separate method calls
    // 5. edge case - no records returned for that year

    // concurrency
    // heavy WRITE
    // paginated READs
  }
}