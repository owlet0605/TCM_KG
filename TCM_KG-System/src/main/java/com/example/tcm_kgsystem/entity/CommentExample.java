package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIsNull() {
            addCriterion("comment_article_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIsNotNull() {
            addCriterion("comment_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdEqualTo(Long value) {
            addCriterion("comment_article_id =", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotEqualTo(Long value) {
            addCriterion("comment_article_id <>", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdGreaterThan(Long value) {
            addCriterion("comment_article_id >", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_article_id >=", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdLessThan(Long value) {
            addCriterion("comment_article_id <", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_article_id <=", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIn(List<Long> values) {
            addCriterion("comment_article_id in", values, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotIn(List<Long> values) {
            addCriterion("comment_article_id not in", values, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdBetween(Long value1, Long value2) {
            addCriterion("comment_article_id between", value1, value2, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_article_id not between", value1, value2, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdIsNull() {
            addCriterion("comment_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdIsNotNull() {
            addCriterion("comment_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdEqualTo(Long value) {
            addCriterion("comment_user_id =", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdNotEqualTo(Long value) {
            addCriterion("comment_user_id <>", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdGreaterThan(Long value) {
            addCriterion("comment_user_id >", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_user_id >=", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdLessThan(Long value) {
            addCriterion("comment_user_id <", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_user_id <=", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdIn(List<Long> values) {
            addCriterion("comment_user_id in", values, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdNotIn(List<Long> values) {
            addCriterion("comment_user_id not in", values, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdBetween(Long value1, Long value2) {
            addCriterion("comment_user_id between", value1, value2, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_user_id not between", value1, value2, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentContextIsNull() {
            addCriterion("comment_context is null");
            return (Criteria) this;
        }

        public Criteria andCommentContextIsNotNull() {
            addCriterion("comment_context is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContextEqualTo(String value) {
            addCriterion("comment_context =", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextNotEqualTo(String value) {
            addCriterion("comment_context <>", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextGreaterThan(String value) {
            addCriterion("comment_context >", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextGreaterThanOrEqualTo(String value) {
            addCriterion("comment_context >=", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextLessThan(String value) {
            addCriterion("comment_context <", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextLessThanOrEqualTo(String value) {
            addCriterion("comment_context <=", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextLike(String value) {
            addCriterion("comment_context like", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextNotLike(String value) {
            addCriterion("comment_context not like", value, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextIn(List<String> values) {
            addCriterion("comment_context in", values, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextNotIn(List<String> values) {
            addCriterion("comment_context not in", values, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextBetween(String value1, String value2) {
            addCriterion("comment_context between", value1, value2, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentContextNotBetween(String value1, String value2) {
            addCriterion("comment_context not between", value1, value2, "commentContext");
            return (Criteria) this;
        }

        public Criteria andCommentLikeIsNull() {
            addCriterion("comment_like is null");
            return (Criteria) this;
        }

        public Criteria andCommentLikeIsNotNull() {
            addCriterion("comment_like is not null");
            return (Criteria) this;
        }

        public Criteria andCommentLikeEqualTo(Integer value) {
            addCriterion("comment_like =", value, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeNotEqualTo(Integer value) {
            addCriterion("comment_like <>", value, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeGreaterThan(Integer value) {
            addCriterion("comment_like >", value, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_like >=", value, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeLessThan(Integer value) {
            addCriterion("comment_like <", value, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeLessThanOrEqualTo(Integer value) {
            addCriterion("comment_like <=", value, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeIn(List<Integer> values) {
            addCriterion("comment_like in", values, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeNotIn(List<Integer> values) {
            addCriterion("comment_like not in", values, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeBetween(Integer value1, Integer value2) {
            addCriterion("comment_like between", value1, value2, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_like not between", value1, value2, "commentLike");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdIsNull() {
            addCriterion("comment_top_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdIsNotNull() {
            addCriterion("comment_top_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdEqualTo(Long value) {
            addCriterion("comment_top_id =", value, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdNotEqualTo(Long value) {
            addCriterion("comment_top_id <>", value, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdGreaterThan(Long value) {
            addCriterion("comment_top_id >", value, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_top_id >=", value, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdLessThan(Long value) {
            addCriterion("comment_top_id <", value, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_top_id <=", value, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdIn(List<Long> values) {
            addCriterion("comment_top_id in", values, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdNotIn(List<Long> values) {
            addCriterion("comment_top_id not in", values, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdBetween(Long value1, Long value2) {
            addCriterion("comment_top_id between", value1, value2, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentTopIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_top_id not between", value1, value2, "commentTopId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdIsNull() {
            addCriterion("comment_for_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentForIdIsNotNull() {
            addCriterion("comment_for_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentForIdEqualTo(Long value) {
            addCriterion("comment_for_id =", value, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdNotEqualTo(Long value) {
            addCriterion("comment_for_id <>", value, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdGreaterThan(Long value) {
            addCriterion("comment_for_id >", value, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_for_id >=", value, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdLessThan(Long value) {
            addCriterion("comment_for_id <", value, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_for_id <=", value, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdIn(List<Long> values) {
            addCriterion("comment_for_id in", values, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdNotIn(List<Long> values) {
            addCriterion("comment_for_id not in", values, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdBetween(Long value1, Long value2) {
            addCriterion("comment_for_id between", value1, value2, "commentForId");
            return (Criteria) this;
        }

        public Criteria andCommentForIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_for_id not between", value1, value2, "commentForId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}