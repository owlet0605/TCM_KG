package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
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

        public Criteria andHistoryIdIsNull() {
            addCriterion("history_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIsNotNull() {
            addCriterion("history_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdEqualTo(Long value) {
            addCriterion("history_id =", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotEqualTo(Long value) {
            addCriterion("history_id <>", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThan(Long value) {
            addCriterion("history_id >", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("history_id >=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThan(Long value) {
            addCriterion("history_id <", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThanOrEqualTo(Long value) {
            addCriterion("history_id <=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIn(List<Long> values) {
            addCriterion("history_id in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotIn(List<Long> values) {
            addCriterion("history_id not in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdBetween(Long value1, Long value2) {
            addCriterion("history_id between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotBetween(Long value1, Long value2) {
            addCriterion("history_id not between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdIsNull() {
            addCriterion("history_article_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdIsNotNull() {
            addCriterion("history_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdEqualTo(Long value) {
            addCriterion("history_article_id =", value, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdNotEqualTo(Long value) {
            addCriterion("history_article_id <>", value, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdGreaterThan(Long value) {
            addCriterion("history_article_id >", value, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("history_article_id >=", value, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdLessThan(Long value) {
            addCriterion("history_article_id <", value, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("history_article_id <=", value, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdIn(List<Long> values) {
            addCriterion("history_article_id in", values, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdNotIn(List<Long> values) {
            addCriterion("history_article_id not in", values, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdBetween(Long value1, Long value2) {
            addCriterion("history_article_id between", value1, value2, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("history_article_id not between", value1, value2, "historyArticleId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdIsNull() {
            addCriterion("history_user_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdIsNotNull() {
            addCriterion("history_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdEqualTo(Long value) {
            addCriterion("history_user_id =", value, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdNotEqualTo(Long value) {
            addCriterion("history_user_id <>", value, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdGreaterThan(Long value) {
            addCriterion("history_user_id >", value, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("history_user_id >=", value, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdLessThan(Long value) {
            addCriterion("history_user_id <", value, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdLessThanOrEqualTo(Long value) {
            addCriterion("history_user_id <=", value, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdIn(List<Long> values) {
            addCriterion("history_user_id in", values, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdNotIn(List<Long> values) {
            addCriterion("history_user_id not in", values, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdBetween(Long value1, Long value2) {
            addCriterion("history_user_id between", value1, value2, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryUserIdNotBetween(Long value1, Long value2) {
            addCriterion("history_user_id not between", value1, value2, "historyUserId");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeIsNull() {
            addCriterion("history_time is null");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeIsNotNull() {
            addCriterion("history_time is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeEqualTo(Date value) {
            addCriterion("history_time =", value, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeNotEqualTo(Date value) {
            addCriterion("history_time <>", value, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeGreaterThan(Date value) {
            addCriterion("history_time >", value, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("history_time >=", value, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeLessThan(Date value) {
            addCriterion("history_time <", value, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeLessThanOrEqualTo(Date value) {
            addCriterion("history_time <=", value, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeIn(List<Date> values) {
            addCriterion("history_time in", values, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeNotIn(List<Date> values) {
            addCriterion("history_time not in", values, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeBetween(Date value1, Date value2) {
            addCriterion("history_time between", value1, value2, "historyTime");
            return (Criteria) this;
        }

        public Criteria andHistoryTimeNotBetween(Date value1, Date value2) {
            addCriterion("history_time not between", value1, value2, "historyTime");
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