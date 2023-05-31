package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatMessageExample() {
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

        public Criteria andChatMessageIdIsNull() {
            addCriterion("chat_message_id is null");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdIsNotNull() {
            addCriterion("chat_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdEqualTo(Long value) {
            addCriterion("chat_message_id =", value, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdNotEqualTo(Long value) {
            addCriterion("chat_message_id <>", value, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdGreaterThan(Long value) {
            addCriterion("chat_message_id >", value, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chat_message_id >=", value, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdLessThan(Long value) {
            addCriterion("chat_message_id <", value, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("chat_message_id <=", value, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdIn(List<Long> values) {
            addCriterion("chat_message_id in", values, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdNotIn(List<Long> values) {
            addCriterion("chat_message_id not in", values, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdBetween(Long value1, Long value2) {
            addCriterion("chat_message_id between", value1, value2, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("chat_message_id not between", value1, value2, "chatMessageId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdIsNull() {
            addCriterion("chat_link_id is null");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdIsNotNull() {
            addCriterion("chat_link_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdEqualTo(Long value) {
            addCriterion("chat_link_id =", value, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdNotEqualTo(Long value) {
            addCriterion("chat_link_id <>", value, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdGreaterThan(Long value) {
            addCriterion("chat_link_id >", value, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chat_link_id >=", value, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdLessThan(Long value) {
            addCriterion("chat_link_id <", value, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdLessThanOrEqualTo(Long value) {
            addCriterion("chat_link_id <=", value, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdIn(List<Long> values) {
            addCriterion("chat_link_id in", values, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdNotIn(List<Long> values) {
            addCriterion("chat_link_id not in", values, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdBetween(Long value1, Long value2) {
            addCriterion("chat_link_id between", value1, value2, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatLinkIdNotBetween(Long value1, Long value2) {
            addCriterion("chat_link_id not between", value1, value2, "chatLinkId");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentIsNull() {
            addCriterion("chat_message_content is null");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentIsNotNull() {
            addCriterion("chat_message_content is not null");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentEqualTo(String value) {
            addCriterion("chat_message_content =", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentNotEqualTo(String value) {
            addCriterion("chat_message_content <>", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentGreaterThan(String value) {
            addCriterion("chat_message_content >", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("chat_message_content >=", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentLessThan(String value) {
            addCriterion("chat_message_content <", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentLessThanOrEqualTo(String value) {
            addCriterion("chat_message_content <=", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentLike(String value) {
            addCriterion("chat_message_content like", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentNotLike(String value) {
            addCriterion("chat_message_content not like", value, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentIn(List<String> values) {
            addCriterion("chat_message_content in", values, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentNotIn(List<String> values) {
            addCriterion("chat_message_content not in", values, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentBetween(String value1, String value2) {
            addCriterion("chat_message_content between", value1, value2, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageContentNotBetween(String value1, String value2) {
            addCriterion("chat_message_content not between", value1, value2, "chatMessageContent");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeIsNull() {
            addCriterion("chat_message_time is null");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeIsNotNull() {
            addCriterion("chat_message_time is not null");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeEqualTo(Date value) {
            addCriterion("chat_message_time =", value, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeNotEqualTo(Date value) {
            addCriterion("chat_message_time <>", value, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeGreaterThan(Date value) {
            addCriterion("chat_message_time >", value, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("chat_message_time >=", value, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeLessThan(Date value) {
            addCriterion("chat_message_time <", value, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeLessThanOrEqualTo(Date value) {
            addCriterion("chat_message_time <=", value, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeIn(List<Date> values) {
            addCriterion("chat_message_time in", values, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeNotIn(List<Date> values) {
            addCriterion("chat_message_time not in", values, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeBetween(Date value1, Date value2) {
            addCriterion("chat_message_time between", value1, value2, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTimeNotBetween(Date value1, Date value2) {
            addCriterion("chat_message_time not between", value1, value2, "chatMessageTime");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeIsNull() {
            addCriterion("chat_message_type is null");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeIsNotNull() {
            addCriterion("chat_message_type is not null");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeEqualTo(String value) {
            addCriterion("chat_message_type =", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeNotEqualTo(String value) {
            addCriterion("chat_message_type <>", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeGreaterThan(String value) {
            addCriterion("chat_message_type >", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("chat_message_type >=", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeLessThan(String value) {
            addCriterion("chat_message_type <", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeLessThanOrEqualTo(String value) {
            addCriterion("chat_message_type <=", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeLike(String value) {
            addCriterion("chat_message_type like", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeNotLike(String value) {
            addCriterion("chat_message_type not like", value, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeIn(List<String> values) {
            addCriterion("chat_message_type in", values, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeNotIn(List<String> values) {
            addCriterion("chat_message_type not in", values, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeBetween(String value1, String value2) {
            addCriterion("chat_message_type between", value1, value2, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageTypeNotBetween(String value1, String value2) {
            addCriterion("chat_message_type not between", value1, value2, "chatMessageType");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestIsNull() {
            addCriterion("chat_message_latest is null");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestIsNotNull() {
            addCriterion("chat_message_latest is not null");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestEqualTo(Integer value) {
            addCriterion("chat_message_latest =", value, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestNotEqualTo(Integer value) {
            addCriterion("chat_message_latest <>", value, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestGreaterThan(Integer value) {
            addCriterion("chat_message_latest >", value, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_message_latest >=", value, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestLessThan(Integer value) {
            addCriterion("chat_message_latest <", value, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestLessThanOrEqualTo(Integer value) {
            addCriterion("chat_message_latest <=", value, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestIn(List<Integer> values) {
            addCriterion("chat_message_latest in", values, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestNotIn(List<Integer> values) {
            addCriterion("chat_message_latest not in", values, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestBetween(Integer value1, Integer value2) {
            addCriterion("chat_message_latest between", value1, value2, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andChatMessageLatestNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_message_latest not between", value1, value2, "chatMessageLatest");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNull() {
            addCriterion("from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNotNull() {
            addCriterion("from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdEqualTo(Long value) {
            addCriterion("from_user_id =", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotEqualTo(Long value) {
            addCriterion("from_user_id <>", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThan(Long value) {
            addCriterion("from_user_id >", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("from_user_id >=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThan(Long value) {
            addCriterion("from_user_id <", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThanOrEqualTo(Long value) {
            addCriterion("from_user_id <=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIn(List<Long> values) {
            addCriterion("from_user_id in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotIn(List<Long> values) {
            addCriterion("from_user_id not in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdBetween(Long value1, Long value2) {
            addCriterion("from_user_id between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotBetween(Long value1, Long value2) {
            addCriterion("from_user_id not between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNull() {
            addCriterion("to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNotNull() {
            addCriterion("to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andToUserIdEqualTo(Long value) {
            addCriterion("to_user_id =", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotEqualTo(Long value) {
            addCriterion("to_user_id <>", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThan(Long value) {
            addCriterion("to_user_id >", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("to_user_id >=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThan(Long value) {
            addCriterion("to_user_id <", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThanOrEqualTo(Long value) {
            addCriterion("to_user_id <=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIn(List<Long> values) {
            addCriterion("to_user_id in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotIn(List<Long> values) {
            addCriterion("to_user_id not in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdBetween(Long value1, Long value2) {
            addCriterion("to_user_id between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotBetween(Long value1, Long value2) {
            addCriterion("to_user_id not between", value1, value2, "toUserId");
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