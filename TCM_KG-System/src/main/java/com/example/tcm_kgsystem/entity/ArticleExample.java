package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIsNull() {
            addCriterion("article_user_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIsNotNull() {
            addCriterion("article_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdEqualTo(Long value) {
            addCriterion("article_user_id =", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotEqualTo(Long value) {
            addCriterion("article_user_id <>", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdGreaterThan(Long value) {
            addCriterion("article_user_id >", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_user_id >=", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdLessThan(Long value) {
            addCriterion("article_user_id <", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdLessThanOrEqualTo(Long value) {
            addCriterion("article_user_id <=", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIn(List<Long> values) {
            addCriterion("article_user_id in", values, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotIn(List<Long> values) {
            addCriterion("article_user_id not in", values, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdBetween(Long value1, Long value2) {
            addCriterion("article_user_id between", value1, value2, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotBetween(Long value1, Long value2) {
            addCriterion("article_user_id not between", value1, value2, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNull() {
            addCriterion("article_type_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNotNull() {
            addCriterion("article_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdEqualTo(Long value) {
            addCriterion("article_type_id =", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotEqualTo(Long value) {
            addCriterion("article_type_id <>", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThan(Long value) {
            addCriterion("article_type_id >", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_type_id >=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThan(Long value) {
            addCriterion("article_type_id <", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("article_type_id <=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIn(List<Long> values) {
            addCriterion("article_type_id in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotIn(List<Long> values) {
            addCriterion("article_type_id not in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdBetween(Long value1, Long value2) {
            addCriterion("article_type_id between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("article_type_id not between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIsNull() {
            addCriterion("article_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIsNotNull() {
            addCriterion("article_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTimeEqualTo(Date value) {
            addCriterion("article_time =", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotEqualTo(Date value) {
            addCriterion("article_time <>", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeGreaterThan(Date value) {
            addCriterion("article_time >", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_time >=", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeLessThan(Date value) {
            addCriterion("article_time <", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_time <=", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIn(List<Date> values) {
            addCriterion("article_time in", values, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotIn(List<Date> values) {
            addCriterion("article_time not in", values, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeBetween(Date value1, Date value2) {
            addCriterion("article_time between", value1, value2, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_time not between", value1, value2, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleViewIsNull() {
            addCriterion("article_view is null");
            return (Criteria) this;
        }

        public Criteria andArticleViewIsNotNull() {
            addCriterion("article_view is not null");
            return (Criteria) this;
        }

        public Criteria andArticleViewEqualTo(Integer value) {
            addCriterion("article_view =", value, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewNotEqualTo(Integer value) {
            addCriterion("article_view <>", value, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewGreaterThan(Integer value) {
            addCriterion("article_view >", value, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_view >=", value, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewLessThan(Integer value) {
            addCriterion("article_view <", value, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewLessThanOrEqualTo(Integer value) {
            addCriterion("article_view <=", value, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewIn(List<Integer> values) {
            addCriterion("article_view in", values, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewNotIn(List<Integer> values) {
            addCriterion("article_view not in", values, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewBetween(Integer value1, Integer value2) {
            addCriterion("article_view between", value1, value2, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleViewNotBetween(Integer value1, Integer value2) {
            addCriterion("article_view not between", value1, value2, "articleView");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIsNull() {
            addCriterion("article_comment is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIsNotNull() {
            addCriterion("article_comment is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentEqualTo(Integer value) {
            addCriterion("article_comment =", value, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentNotEqualTo(Integer value) {
            addCriterion("article_comment <>", value, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentGreaterThan(Integer value) {
            addCriterion("article_comment >", value, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_comment >=", value, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentLessThan(Integer value) {
            addCriterion("article_comment <", value, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentLessThanOrEqualTo(Integer value) {
            addCriterion("article_comment <=", value, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIn(List<Integer> values) {
            addCriterion("article_comment in", values, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentNotIn(List<Integer> values) {
            addCriterion("article_comment not in", values, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentBetween(Integer value1, Integer value2) {
            addCriterion("article_comment between", value1, value2, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("article_comment not between", value1, value2, "articleComment");
            return (Criteria) this;
        }

        public Criteria andArticleLikeIsNull() {
            addCriterion("article_like is null");
            return (Criteria) this;
        }

        public Criteria andArticleLikeIsNotNull() {
            addCriterion("article_like is not null");
            return (Criteria) this;
        }

        public Criteria andArticleLikeEqualTo(Integer value) {
            addCriterion("article_like =", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeNotEqualTo(Integer value) {
            addCriterion("article_like <>", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeGreaterThan(Integer value) {
            addCriterion("article_like >", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_like >=", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeLessThan(Integer value) {
            addCriterion("article_like <", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeLessThanOrEqualTo(Integer value) {
            addCriterion("article_like <=", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeIn(List<Integer> values) {
            addCriterion("article_like in", values, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeNotIn(List<Integer> values) {
            addCriterion("article_like not in", values, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeBetween(Integer value1, Integer value2) {
            addCriterion("article_like between", value1, value2, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("article_like not between", value1, value2, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleCollectIsNull() {
            addCriterion("article_collect is null");
            return (Criteria) this;
        }

        public Criteria andArticleCollectIsNotNull() {
            addCriterion("article_collect is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCollectEqualTo(Integer value) {
            addCriterion("article_collect =", value, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectNotEqualTo(Integer value) {
            addCriterion("article_collect <>", value, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectGreaterThan(Integer value) {
            addCriterion("article_collect >", value, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_collect >=", value, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectLessThan(Integer value) {
            addCriterion("article_collect <", value, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectLessThanOrEqualTo(Integer value) {
            addCriterion("article_collect <=", value, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectIn(List<Integer> values) {
            addCriterion("article_collect in", values, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectNotIn(List<Integer> values) {
            addCriterion("article_collect not in", values, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectBetween(Integer value1, Integer value2) {
            addCriterion("article_collect between", value1, value2, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleCollectNotBetween(Integer value1, Integer value2) {
            addCriterion("article_collect not between", value1, value2, "articleCollect");
            return (Criteria) this;
        }

        public Criteria andArticleAuditIsNull() {
            addCriterion("article_audit is null");
            return (Criteria) this;
        }

        public Criteria andArticleAuditIsNotNull() {
            addCriterion("article_audit is not null");
            return (Criteria) this;
        }

        public Criteria andArticleAuditEqualTo(Integer value) {
            addCriterion("article_audit =", value, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditNotEqualTo(Integer value) {
            addCriterion("article_audit <>", value, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditGreaterThan(Integer value) {
            addCriterion("article_audit >", value, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_audit >=", value, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditLessThan(Integer value) {
            addCriterion("article_audit <", value, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditLessThanOrEqualTo(Integer value) {
            addCriterion("article_audit <=", value, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditIn(List<Integer> values) {
            addCriterion("article_audit in", values, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditNotIn(List<Integer> values) {
            addCriterion("article_audit not in", values, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditBetween(Integer value1, Integer value2) {
            addCriterion("article_audit between", value1, value2, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("article_audit not between", value1, value2, "articleAudit");
            return (Criteria) this;
        }

        public Criteria andArticleTagIsNull() {
            addCriterion("article_tag is null");
            return (Criteria) this;
        }

        public Criteria andArticleTagIsNotNull() {
            addCriterion("article_tag is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTagEqualTo(String value) {
            addCriterion("article_tag =", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagNotEqualTo(String value) {
            addCriterion("article_tag <>", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagGreaterThan(String value) {
            addCriterion("article_tag >", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagGreaterThanOrEqualTo(String value) {
            addCriterion("article_tag >=", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagLessThan(String value) {
            addCriterion("article_tag <", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagLessThanOrEqualTo(String value) {
            addCriterion("article_tag <=", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagLike(String value) {
            addCriterion("article_tag like", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagNotLike(String value) {
            addCriterion("article_tag not like", value, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagIn(List<String> values) {
            addCriterion("article_tag in", values, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagNotIn(List<String> values) {
            addCriterion("article_tag not in", values, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagBetween(String value1, String value2) {
            addCriterion("article_tag between", value1, value2, "articleTag");
            return (Criteria) this;
        }

        public Criteria andArticleTagNotBetween(String value1, String value2) {
            addCriterion("article_tag not between", value1, value2, "articleTag");
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