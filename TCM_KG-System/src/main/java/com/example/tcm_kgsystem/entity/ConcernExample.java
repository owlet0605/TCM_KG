package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class ConcernExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConcernExample() {
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

        public Criteria andConcernIdIsNull() {
            addCriterion("concern_id is null");
            return (Criteria) this;
        }

        public Criteria andConcernIdIsNotNull() {
            addCriterion("concern_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcernIdEqualTo(Long value) {
            addCriterion("concern_id =", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotEqualTo(Long value) {
            addCriterion("concern_id <>", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdGreaterThan(Long value) {
            addCriterion("concern_id >", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdGreaterThanOrEqualTo(Long value) {
            addCriterion("concern_id >=", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLessThan(Long value) {
            addCriterion("concern_id <", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLessThanOrEqualTo(Long value) {
            addCriterion("concern_id <=", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdIn(List<Long> values) {
            addCriterion("concern_id in", values, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotIn(List<Long> values) {
            addCriterion("concern_id not in", values, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdBetween(Long value1, Long value2) {
            addCriterion("concern_id between", value1, value2, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotBetween(Long value1, Long value2) {
            addCriterion("concern_id not between", value1, value2, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdIsNull() {
            addCriterion("concern_user_id is null");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdIsNotNull() {
            addCriterion("concern_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdEqualTo(Long value) {
            addCriterion("concern_user_id =", value, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdNotEqualTo(Long value) {
            addCriterion("concern_user_id <>", value, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdGreaterThan(Long value) {
            addCriterion("concern_user_id >", value, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("concern_user_id >=", value, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdLessThan(Long value) {
            addCriterion("concern_user_id <", value, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdLessThanOrEqualTo(Long value) {
            addCriterion("concern_user_id <=", value, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdIn(List<Long> values) {
            addCriterion("concern_user_id in", values, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdNotIn(List<Long> values) {
            addCriterion("concern_user_id not in", values, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdBetween(Long value1, Long value2) {
            addCriterion("concern_user_id between", value1, value2, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernUserIdNotBetween(Long value1, Long value2) {
            addCriterion("concern_user_id not between", value1, value2, "concernUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdIsNull() {
            addCriterion("concerned_user_id is null");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdIsNotNull() {
            addCriterion("concerned_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdEqualTo(Long value) {
            addCriterion("concerned_user_id =", value, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdNotEqualTo(Long value) {
            addCriterion("concerned_user_id <>", value, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdGreaterThan(Long value) {
            addCriterion("concerned_user_id >", value, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("concerned_user_id >=", value, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdLessThan(Long value) {
            addCriterion("concerned_user_id <", value, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdLessThanOrEqualTo(Long value) {
            addCriterion("concerned_user_id <=", value, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdIn(List<Long> values) {
            addCriterion("concerned_user_id in", values, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdNotIn(List<Long> values) {
            addCriterion("concerned_user_id not in", values, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdBetween(Long value1, Long value2) {
            addCriterion("concerned_user_id between", value1, value2, "concernedUserId");
            return (Criteria) this;
        }

        public Criteria andConcernedUserIdNotBetween(Long value1, Long value2) {
            addCriterion("concerned_user_id not between", value1, value2, "concernedUserId");
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