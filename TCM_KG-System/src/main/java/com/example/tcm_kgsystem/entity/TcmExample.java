package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class TcmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TcmExample() {
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

        public Criteria andTcmIdIsNull() {
            addCriterion("tcm_id is null");
            return (Criteria) this;
        }

        public Criteria andTcmIdIsNotNull() {
            addCriterion("tcm_id is not null");
            return (Criteria) this;
        }

        public Criteria andTcmIdEqualTo(Long value) {
            addCriterion("tcm_id =", value, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdNotEqualTo(Long value) {
            addCriterion("tcm_id <>", value, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdGreaterThan(Long value) {
            addCriterion("tcm_id >", value, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tcm_id >=", value, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdLessThan(Long value) {
            addCriterion("tcm_id <", value, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdLessThanOrEqualTo(Long value) {
            addCriterion("tcm_id <=", value, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdIn(List<Long> values) {
            addCriterion("tcm_id in", values, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdNotIn(List<Long> values) {
            addCriterion("tcm_id not in", values, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdBetween(Long value1, Long value2) {
            addCriterion("tcm_id between", value1, value2, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmIdNotBetween(Long value1, Long value2) {
            addCriterion("tcm_id not between", value1, value2, "tcmId");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhIsNull() {
            addCriterion("tcm_name_zh is null");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhIsNotNull() {
            addCriterion("tcm_name_zh is not null");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhEqualTo(String value) {
            addCriterion("tcm_name_zh =", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhNotEqualTo(String value) {
            addCriterion("tcm_name_zh <>", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhGreaterThan(String value) {
            addCriterion("tcm_name_zh >", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhGreaterThanOrEqualTo(String value) {
            addCriterion("tcm_name_zh >=", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhLessThan(String value) {
            addCriterion("tcm_name_zh <", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhLessThanOrEqualTo(String value) {
            addCriterion("tcm_name_zh <=", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhLike(String value) {
            addCriterion("tcm_name_zh like", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhNotLike(String value) {
            addCriterion("tcm_name_zh not like", value, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhIn(List<String> values) {
            addCriterion("tcm_name_zh in", values, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhNotIn(List<String> values) {
            addCriterion("tcm_name_zh not in", values, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhBetween(String value1, String value2) {
            addCriterion("tcm_name_zh between", value1, value2, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameZhNotBetween(String value1, String value2) {
            addCriterion("tcm_name_zh not between", value1, value2, "tcmNameZh");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnIsNull() {
            addCriterion("tcm_name_en is null");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnIsNotNull() {
            addCriterion("tcm_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnEqualTo(String value) {
            addCriterion("tcm_name_en =", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnNotEqualTo(String value) {
            addCriterion("tcm_name_en <>", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnGreaterThan(String value) {
            addCriterion("tcm_name_en >", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("tcm_name_en >=", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnLessThan(String value) {
            addCriterion("tcm_name_en <", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnLessThanOrEqualTo(String value) {
            addCriterion("tcm_name_en <=", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnLike(String value) {
            addCriterion("tcm_name_en like", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnNotLike(String value) {
            addCriterion("tcm_name_en not like", value, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnIn(List<String> values) {
            addCriterion("tcm_name_en in", values, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnNotIn(List<String> values) {
            addCriterion("tcm_name_en not in", values, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnBetween(String value1, String value2) {
            addCriterion("tcm_name_en between", value1, value2, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmNameEnNotBetween(String value1, String value2) {
            addCriterion("tcm_name_en not between", value1, value2, "tcmNameEn");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinIsNull() {
            addCriterion("tcm_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinIsNotNull() {
            addCriterion("tcm_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinEqualTo(String value) {
            addCriterion("tcm_pinyin =", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinNotEqualTo(String value) {
            addCriterion("tcm_pinyin <>", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinGreaterThan(String value) {
            addCriterion("tcm_pinyin >", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("tcm_pinyin >=", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinLessThan(String value) {
            addCriterion("tcm_pinyin <", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinLessThanOrEqualTo(String value) {
            addCriterion("tcm_pinyin <=", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinLike(String value) {
            addCriterion("tcm_pinyin like", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinNotLike(String value) {
            addCriterion("tcm_pinyin not like", value, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinIn(List<String> values) {
            addCriterion("tcm_pinyin in", values, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinNotIn(List<String> values) {
            addCriterion("tcm_pinyin not in", values, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinBetween(String value1, String value2) {
            addCriterion("tcm_pinyin between", value1, value2, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmPinyinNotBetween(String value1, String value2) {
            addCriterion("tcm_pinyin not between", value1, value2, "tcmPinyin");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveIsNull() {
            addCriterion("tcm_inductive is null");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveIsNotNull() {
            addCriterion("tcm_inductive is not null");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveEqualTo(String value) {
            addCriterion("tcm_inductive =", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveNotEqualTo(String value) {
            addCriterion("tcm_inductive <>", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveGreaterThan(String value) {
            addCriterion("tcm_inductive >", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveGreaterThanOrEqualTo(String value) {
            addCriterion("tcm_inductive >=", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveLessThan(String value) {
            addCriterion("tcm_inductive <", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveLessThanOrEqualTo(String value) {
            addCriterion("tcm_inductive <=", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveLike(String value) {
            addCriterion("tcm_inductive like", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveNotLike(String value) {
            addCriterion("tcm_inductive not like", value, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveIn(List<String> values) {
            addCriterion("tcm_inductive in", values, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveNotIn(List<String> values) {
            addCriterion("tcm_inductive not in", values, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveBetween(String value1, String value2) {
            addCriterion("tcm_inductive between", value1, value2, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmInductiveNotBetween(String value1, String value2) {
            addCriterion("tcm_inductive not between", value1, value2, "tcmInductive");
            return (Criteria) this;
        }

        public Criteria andTcmTasteIsNull() {
            addCriterion("tcm_taste is null");
            return (Criteria) this;
        }

        public Criteria andTcmTasteIsNotNull() {
            addCriterion("tcm_taste is not null");
            return (Criteria) this;
        }

        public Criteria andTcmTasteEqualTo(String value) {
            addCriterion("tcm_taste =", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteNotEqualTo(String value) {
            addCriterion("tcm_taste <>", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteGreaterThan(String value) {
            addCriterion("tcm_taste >", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteGreaterThanOrEqualTo(String value) {
            addCriterion("tcm_taste >=", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteLessThan(String value) {
            addCriterion("tcm_taste <", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteLessThanOrEqualTo(String value) {
            addCriterion("tcm_taste <=", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteLike(String value) {
            addCriterion("tcm_taste like", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteNotLike(String value) {
            addCriterion("tcm_taste not like", value, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteIn(List<String> values) {
            addCriterion("tcm_taste in", values, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteNotIn(List<String> values) {
            addCriterion("tcm_taste not in", values, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteBetween(String value1, String value2) {
            addCriterion("tcm_taste between", value1, value2, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmTasteNotBetween(String value1, String value2) {
            addCriterion("tcm_taste not between", value1, value2, "tcmTaste");
            return (Criteria) this;
        }

        public Criteria andTcmAliasIsNull() {
            addCriterion("tcm_alias is null");
            return (Criteria) this;
        }

        public Criteria andTcmAliasIsNotNull() {
            addCriterion("tcm_alias is not null");
            return (Criteria) this;
        }

        public Criteria andTcmAliasEqualTo(String value) {
            addCriterion("tcm_alias =", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasNotEqualTo(String value) {
            addCriterion("tcm_alias <>", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasGreaterThan(String value) {
            addCriterion("tcm_alias >", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasGreaterThanOrEqualTo(String value) {
            addCriterion("tcm_alias >=", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasLessThan(String value) {
            addCriterion("tcm_alias <", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasLessThanOrEqualTo(String value) {
            addCriterion("tcm_alias <=", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasLike(String value) {
            addCriterion("tcm_alias like", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasNotLike(String value) {
            addCriterion("tcm_alias not like", value, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasIn(List<String> values) {
            addCriterion("tcm_alias in", values, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasNotIn(List<String> values) {
            addCriterion("tcm_alias not in", values, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasBetween(String value1, String value2) {
            addCriterion("tcm_alias between", value1, value2, "tcmAlias");
            return (Criteria) this;
        }

        public Criteria andTcmAliasNotBetween(String value1, String value2) {
            addCriterion("tcm_alias not between", value1, value2, "tcmAlias");
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