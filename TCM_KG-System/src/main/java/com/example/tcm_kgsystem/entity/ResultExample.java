package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultExample() {
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

        public Criteria andResultIdIsNull() {
            addCriterion("result_id is null");
            return (Criteria) this;
        }

        public Criteria andResultIdIsNotNull() {
            addCriterion("result_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultIdEqualTo(Long value) {
            addCriterion("result_id =", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotEqualTo(Long value) {
            addCriterion("result_id <>", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdGreaterThan(Long value) {
            addCriterion("result_id >", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdGreaterThanOrEqualTo(Long value) {
            addCriterion("result_id >=", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLessThan(Long value) {
            addCriterion("result_id <", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLessThanOrEqualTo(Long value) {
            addCriterion("result_id <=", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdIn(List<Long> values) {
            addCriterion("result_id in", values, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotIn(List<Long> values) {
            addCriterion("result_id not in", values, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdBetween(Long value1, Long value2) {
            addCriterion("result_id between", value1, value2, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotBetween(Long value1, Long value2) {
            addCriterion("result_id not between", value1, value2, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdIsNull() {
            addCriterion("result_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdIsNotNull() {
            addCriterion("result_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdEqualTo(Long value) {
            addCriterion("result_admin_id =", value, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdNotEqualTo(Long value) {
            addCriterion("result_admin_id <>", value, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdGreaterThan(Long value) {
            addCriterion("result_admin_id >", value, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("result_admin_id >=", value, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdLessThan(Long value) {
            addCriterion("result_admin_id <", value, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("result_admin_id <=", value, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdIn(List<Long> values) {
            addCriterion("result_admin_id in", values, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdNotIn(List<Long> values) {
            addCriterion("result_admin_id not in", values, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdBetween(Long value1, Long value2) {
            addCriterion("result_admin_id between", value1, value2, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("result_admin_id not between", value1, value2, "resultAdminId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdIsNull() {
            addCriterion("result_user_id is null");
            return (Criteria) this;
        }

        public Criteria andResultUserIdIsNotNull() {
            addCriterion("result_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultUserIdEqualTo(Long value) {
            addCriterion("result_user_id =", value, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdNotEqualTo(Long value) {
            addCriterion("result_user_id <>", value, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdGreaterThan(Long value) {
            addCriterion("result_user_id >", value, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("result_user_id >=", value, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdLessThan(Long value) {
            addCriterion("result_user_id <", value, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdLessThanOrEqualTo(Long value) {
            addCriterion("result_user_id <=", value, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdIn(List<Long> values) {
            addCriterion("result_user_id in", values, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdNotIn(List<Long> values) {
            addCriterion("result_user_id not in", values, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdBetween(Long value1, Long value2) {
            addCriterion("result_user_id between", value1, value2, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultUserIdNotBetween(Long value1, Long value2) {
            addCriterion("result_user_id not between", value1, value2, "resultUserId");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNull() {
            addCriterion("result_type is null");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNotNull() {
            addCriterion("result_type is not null");
            return (Criteria) this;
        }

        public Criteria andResultTypeEqualTo(String value) {
            addCriterion("result_type =", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotEqualTo(String value) {
            addCriterion("result_type <>", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThan(String value) {
            addCriterion("result_type >", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("result_type >=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThan(String value) {
            addCriterion("result_type <", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThanOrEqualTo(String value) {
            addCriterion("result_type <=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLike(String value) {
            addCriterion("result_type like", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotLike(String value) {
            addCriterion("result_type not like", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeIn(List<String> values) {
            addCriterion("result_type in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotIn(List<String> values) {
            addCriterion("result_type not in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeBetween(String value1, String value2) {
            addCriterion("result_type between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotBetween(String value1, String value2) {
            addCriterion("result_type not between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTimeIsNull() {
            addCriterion("result_time is null");
            return (Criteria) this;
        }

        public Criteria andResultTimeIsNotNull() {
            addCriterion("result_time is not null");
            return (Criteria) this;
        }

        public Criteria andResultTimeEqualTo(Date value) {
            addCriterion("result_time =", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeNotEqualTo(Date value) {
            addCriterion("result_time <>", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeGreaterThan(Date value) {
            addCriterion("result_time >", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("result_time >=", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeLessThan(Date value) {
            addCriterion("result_time <", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeLessThanOrEqualTo(Date value) {
            addCriterion("result_time <=", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeIn(List<Date> values) {
            addCriterion("result_time in", values, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeNotIn(List<Date> values) {
            addCriterion("result_time not in", values, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeBetween(Date value1, Date value2) {
            addCriterion("result_time between", value1, value2, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeNotBetween(Date value1, Date value2) {
            addCriterion("result_time not between", value1, value2, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultHaveIsNull() {
            addCriterion("result_have is null");
            return (Criteria) this;
        }

        public Criteria andResultHaveIsNotNull() {
            addCriterion("result_have is not null");
            return (Criteria) this;
        }

        public Criteria andResultHaveEqualTo(Integer value) {
            addCriterion("result_have =", value, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveNotEqualTo(Integer value) {
            addCriterion("result_have <>", value, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveGreaterThan(Integer value) {
            addCriterion("result_have >", value, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_have >=", value, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveLessThan(Integer value) {
            addCriterion("result_have <", value, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveLessThanOrEqualTo(Integer value) {
            addCriterion("result_have <=", value, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveIn(List<Integer> values) {
            addCriterion("result_have in", values, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveNotIn(List<Integer> values) {
            addCriterion("result_have not in", values, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveBetween(Integer value1, Integer value2) {
            addCriterion("result_have between", value1, value2, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultHaveNotBetween(Integer value1, Integer value2) {
            addCriterion("result_have not between", value1, value2, "resultHave");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdIsNull() {
            addCriterion("result_object_id is null");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdIsNotNull() {
            addCriterion("result_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdEqualTo(Long value) {
            addCriterion("result_object_id =", value, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdNotEqualTo(Long value) {
            addCriterion("result_object_id <>", value, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdGreaterThan(Long value) {
            addCriterion("result_object_id >", value, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("result_object_id >=", value, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdLessThan(Long value) {
            addCriterion("result_object_id <", value, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("result_object_id <=", value, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdIn(List<Long> values) {
            addCriterion("result_object_id in", values, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdNotIn(List<Long> values) {
            addCriterion("result_object_id not in", values, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdBetween(Long value1, Long value2) {
            addCriterion("result_object_id between", value1, value2, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("result_object_id not between", value1, value2, "resultObjectId");
            return (Criteria) this;
        }

        public Criteria andResultObjectIsNull() {
            addCriterion("result_object is null");
            return (Criteria) this;
        }

        public Criteria andResultObjectIsNotNull() {
            addCriterion("result_object is not null");
            return (Criteria) this;
        }

        public Criteria andResultObjectEqualTo(String value) {
            addCriterion("result_object =", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectNotEqualTo(String value) {
            addCriterion("result_object <>", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectGreaterThan(String value) {
            addCriterion("result_object >", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectGreaterThanOrEqualTo(String value) {
            addCriterion("result_object >=", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectLessThan(String value) {
            addCriterion("result_object <", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectLessThanOrEqualTo(String value) {
            addCriterion("result_object <=", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectLike(String value) {
            addCriterion("result_object like", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectNotLike(String value) {
            addCriterion("result_object not like", value, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectIn(List<String> values) {
            addCriterion("result_object in", values, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectNotIn(List<String> values) {
            addCriterion("result_object not in", values, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectBetween(String value1, String value2) {
            addCriterion("result_object between", value1, value2, "resultObject");
            return (Criteria) this;
        }

        public Criteria andResultObjectNotBetween(String value1, String value2) {
            addCriterion("result_object not between", value1, value2, "resultObject");
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