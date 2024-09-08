package com.evidences.common.util;

import com.evidences.common.dto.Pagination;
import com.evidences.common.dto.PaginationResult;
import com.evidences.common.dto.RowBounds;

public class PaginationUtils {
    @FunctionalInterface
    public interface QueryCount {
        Integer execute();
    }

    @FunctionalInterface
    public interface QueryResults {
        Object execute();
    }

    public static class PaginationExecutor {
        private Pagination pagination;
        private PaginationResult paginationResult;

        public PaginationExecutor(Pagination pagination) {
            this.pagination = pagination;
            this.paginationResult = new PaginationResult();
        }

        public PaginationExecutor results(QueryResults queryResults) {
            paginationResult.setResults(queryResults.execute());
            return this;
        }

        public PaginationResult count(QueryCount queryCount) {
            int totalCount = queryCount.execute();

            paginationResult.setTotalCount(totalCount);
            paginationResult.setPageCount(PaginationUtils.pageCount(totalCount, pagination.getPageSize()));

            return paginationResult;
        }
    }

    public static RowBounds rowBounds(Pagination pagination) {
        int count = pagination.getPageSize();
        int index = pagination.getPageNum();

        return new RowBounds(count, (index - 1) * count);
    }

    public static int pageCount(int resultCount, int pageSize) {
        return resultCount / pageSize + (resultCount % pageSize == 0 ? 0 : 1);
    }

    public static PaginationExecutor execute(Pagination pagination) {
        return new PaginationExecutor(pagination);
    }
}
