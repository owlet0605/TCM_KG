package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuditExample() {
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

        public Criteria andAuditIdIsNull() {
            addCriterion("audit_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNotNull() {
            addCriterion("audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditIdEqualTo(Long value) {
            addCriterion("audit_id =", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotEqualTo(Long value) {
            addCriterion("audit_id <>", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThan(Long value) {
            addCriterion("audit_id >", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_id >=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThan(Long value) {
            addCriterion("audit_id <", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_id <=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIn(List<Long> values) {
            addCriterion("audit_id in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotIn(List<Long> values) {
            addCriterion("audit_id not in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdBetween(Long value1, Long value2) {
            addCriterion("audit_id between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_id not between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdIsNull() {
            addCriterion("audit_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdIsNotNull() {
            addCriterion("audit_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdEqualTo(Long value) {
            addCriterion("audit_admin_id =", value, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdNotEqualTo(Long value) {
            addCriterion("audit_admin_id <>", value, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdGreaterThan(Long value) {
            addCriterion("audit_admin_id >", value, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_admin_id >=", value, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdLessThan(Long value) {
            addCriterion("audit_admin_id <", value, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_admin_id <=", value, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdIn(List<Long> values) {
            addCriterion("audit_admin_id in", values, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdNotIn(List<Long> values) {
            addCriterion("audit_admin_id not in", values, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdBetween(Long value1, Long value2) {
            addCriterion("audit_admin_id between", value1, value2, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_admin_id not between", value1, value2, "auditAdminId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNull() {
            addCriterion("audit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNotNull() {
            addCriterion("audit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdEqualTo(Long value) {
            addCriterion("audit_user_id =", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotEqualTo(Long value) {
            addCriterion("audit_user_id <>", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThan(Long value) {
            addCriterion("audit_user_id >", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_user_id >=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThan(Long value) {
            addCriterion("audit_user_id <", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_user_id <=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIn(List<Long> values) {
            addCriterion("audit_user_id in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotIn(List<Long> values) {
            addCriterion("audit_user_id not in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdBetween(Long value1, Long value2) {
            addCriterion("audit_user_id between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_user_id not between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdIsNull() {
            addCriterion("audit_article_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdIsNotNull() {
            addCriterion("audit_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdEqualTo(Long value) {
            addCriterion("audit_article_id =", value, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdNotEqualTo(Long value) {
            addCriterion("audit_article_id <>", value, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdGreaterThan(Long value) {
            addCriterion("audit_article_id >", value, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_article_id >=", value, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdLessThan(Long value) {
            addCriterion("audit_article_id <", value, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_article_id <=", value, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdIn(List<Long> values) {
            addCriterion("audit_article_id in", values, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdNotIn(List<Long> values) {
            addCriterion("audit_article_id not in", values, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdBetween(Long value1, Long value2) {
            addCriterion("audit_article_id between", value1, value2, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_article_id not between", value1, value2, "auditArticleId");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditHaveIsNull() {
            addCriterion("audit_have is null");
            return (Criteria) this;
        }

        public Criteria andAuditHaveIsNotNull() {
            addCriterion("audit_have is not null");
            return (Criteria) this;
        }

        public Criteria andAuditHaveEqualTo(Integer value) {
            addCriterion("audit_have =", value, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveNotEqualTo(Integer value) {
            addCriterion("audit_have <>", value, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveGreaterThan(Integer value) {
            addCriterion("audit_have >", value, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_have >=", value, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveLessThan(Integer value) {
            addCriterion("audit_have <", value, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveLessThanOrEqualTo(Integer value) {
            addCriterion("audit_have <=", value, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveIn(List<Integer> values) {
            addCriterion("audit_have in", values, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveNotIn(List<Integer> values) {
            addCriterion("audit_have not in", values, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveBetween(Integer value1, Integer value2) {
            addCriterion("audit_have between", value1, value2, "auditHave");
            return (Criteria) this;
        }

        public Criteria andAuditHaveNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_have not between", value1, value2, "auditHave");
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