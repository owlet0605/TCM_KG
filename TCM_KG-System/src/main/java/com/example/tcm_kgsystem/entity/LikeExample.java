package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LikeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LikeExample() {
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

        public Criteria andLikeIdIsNull() {
            addCriterion("like_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeIdIsNotNull() {
            addCriterion("like_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeIdEqualTo(Long value) {
            addCriterion("like_id =", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotEqualTo(Long value) {
            addCriterion("like_id <>", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThan(Long value) {
            addCriterion("like_id >", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_id >=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThan(Long value) {
            addCriterion("like_id <", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThanOrEqualTo(Long value) {
            addCriterion("like_id <=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdIn(List<Long> values) {
            addCriterion("like_id in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotIn(List<Long> values) {
            addCriterion("like_id not in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdBetween(Long value1, Long value2) {
            addCriterion("like_id between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotBetween(Long value1, Long value2) {
            addCriterion("like_id not between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdIsNull() {
            addCriterion("like_article_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdIsNotNull() {
            addCriterion("like_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdEqualTo(Long value) {
            addCriterion("like_article_id =", value, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdNotEqualTo(Long value) {
            addCriterion("like_article_id <>", value, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdGreaterThan(Long value) {
            addCriterion("like_article_id >", value, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_article_id >=", value, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdLessThan(Long value) {
            addCriterion("like_article_id <", value, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("like_article_id <=", value, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdIn(List<Long> values) {
            addCriterion("like_article_id in", values, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdNotIn(List<Long> values) {
            addCriterion("like_article_id not in", values, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdBetween(Long value1, Long value2) {
            addCriterion("like_article_id between", value1, value2, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("like_article_id not between", value1, value2, "likeArticleId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNull() {
            addCriterion("like_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNotNull() {
            addCriterion("like_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdEqualTo(Long value) {
            addCriterion("like_user_id =", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotEqualTo(Long value) {
            addCriterion("like_user_id <>", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThan(Long value) {
            addCriterion("like_user_id >", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_user_id >=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThan(Long value) {
            addCriterion("like_user_id <", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThanOrEqualTo(Long value) {
            addCriterion("like_user_id <=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIn(List<Long> values) {
            addCriterion("like_user_id in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotIn(List<Long> values) {
            addCriterion("like_user_id not in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdBetween(Long value1, Long value2) {
            addCriterion("like_user_id between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotBetween(Long value1, Long value2) {
            addCriterion("like_user_id not between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeTypeIsNull() {
            addCriterion("like_type is null");
            return (Criteria) this;
        }

        public Criteria andLikeTypeIsNotNull() {
            addCriterion("like_type is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTypeEqualTo(String value) {
            addCriterion("like_type =", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotEqualTo(String value) {
            addCriterion("like_type <>", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeGreaterThan(String value) {
            addCriterion("like_type >", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("like_type >=", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeLessThan(String value) {
            addCriterion("like_type <", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeLessThanOrEqualTo(String value) {
            addCriterion("like_type <=", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeLike(String value) {
            addCriterion("like_type like", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotLike(String value) {
            addCriterion("like_type not like", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeIn(List<String> values) {
            addCriterion("like_type in", values, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotIn(List<String> values) {
            addCriterion("like_type not in", values, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeBetween(String value1, String value2) {
            addCriterion("like_type between", value1, value2, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotBetween(String value1, String value2) {
            addCriterion("like_type not between", value1, value2, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdIsNull() {
            addCriterion("like_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdIsNotNull() {
            addCriterion("like_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdEqualTo(Long value) {
            addCriterion("like_comment_id =", value, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdNotEqualTo(Long value) {
            addCriterion("like_comment_id <>", value, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdGreaterThan(Long value) {
            addCriterion("like_comment_id >", value, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_comment_id >=", value, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdLessThan(Long value) {
            addCriterion("like_comment_id <", value, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("like_comment_id <=", value, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdIn(List<Long> values) {
            addCriterion("like_comment_id in", values, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdNotIn(List<Long> values) {
            addCriterion("like_comment_id not in", values, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdBetween(Long value1, Long value2) {
            addCriterion("like_comment_id between", value1, value2, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("like_comment_id not between", value1, value2, "likeCommentId");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("like_time is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("like_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("like_time =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("like_time <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("like_time >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("like_time >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("like_time <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("like_time <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("like_time in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("like_time not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("like_time between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("like_time not between", value1, value2, "likeTime");
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