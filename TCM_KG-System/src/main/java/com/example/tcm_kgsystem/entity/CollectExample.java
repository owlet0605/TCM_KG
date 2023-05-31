package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectExample() {
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

        public Criteria andCollectIdIsNull() {
            addCriterion("collect_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNotNull() {
            addCriterion("collect_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectIdEqualTo(Long value) {
            addCriterion("collect_id =", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotEqualTo(Long value) {
            addCriterion("collect_id <>", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThan(Long value) {
            addCriterion("collect_id >", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collect_id >=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThan(Long value) {
            addCriterion("collect_id <", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThanOrEqualTo(Long value) {
            addCriterion("collect_id <=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdIn(List<Long> values) {
            addCriterion("collect_id in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotIn(List<Long> values) {
            addCriterion("collect_id not in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdBetween(Long value1, Long value2) {
            addCriterion("collect_id between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotBetween(Long value1, Long value2) {
            addCriterion("collect_id not between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdIsNull() {
            addCriterion("collect_article_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdIsNotNull() {
            addCriterion("collect_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdEqualTo(Long value) {
            addCriterion("collect_article_id =", value, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdNotEqualTo(Long value) {
            addCriterion("collect_article_id <>", value, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdGreaterThan(Long value) {
            addCriterion("collect_article_id >", value, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collect_article_id >=", value, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdLessThan(Long value) {
            addCriterion("collect_article_id <", value, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("collect_article_id <=", value, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdIn(List<Long> values) {
            addCriterion("collect_article_id in", values, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdNotIn(List<Long> values) {
            addCriterion("collect_article_id not in", values, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdBetween(Long value1, Long value2) {
            addCriterion("collect_article_id between", value1, value2, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("collect_article_id not between", value1, value2, "collectArticleId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdIsNull() {
            addCriterion("collect_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdIsNotNull() {
            addCriterion("collect_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdEqualTo(Long value) {
            addCriterion("collect_user_id =", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdNotEqualTo(Long value) {
            addCriterion("collect_user_id <>", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdGreaterThan(Long value) {
            addCriterion("collect_user_id >", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collect_user_id >=", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdLessThan(Long value) {
            addCriterion("collect_user_id <", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdLessThanOrEqualTo(Long value) {
            addCriterion("collect_user_id <=", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdIn(List<Long> values) {
            addCriterion("collect_user_id in", values, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdNotIn(List<Long> values) {
            addCriterion("collect_user_id not in", values, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdBetween(Long value1, Long value2) {
            addCriterion("collect_user_id between", value1, value2, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdNotBetween(Long value1, Long value2) {
            addCriterion("collect_user_id not between", value1, value2, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNull() {
            addCriterion("collect_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNotNull() {
            addCriterion("collect_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeEqualTo(Date value) {
            addCriterion("collect_time =", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotEqualTo(Date value) {
            addCriterion("collect_time <>", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThan(Date value) {
            addCriterion("collect_time >", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_time >=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThan(Date value) {
            addCriterion("collect_time <", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThanOrEqualTo(Date value) {
            addCriterion("collect_time <=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIn(List<Date> values) {
            addCriterion("collect_time in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotIn(List<Date> values) {
            addCriterion("collect_time not in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeBetween(Date value1, Date value2) {
            addCriterion("collect_time between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotBetween(Date value1, Date value2) {
            addCriterion("collect_time not between", value1, value2, "collectTime");
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