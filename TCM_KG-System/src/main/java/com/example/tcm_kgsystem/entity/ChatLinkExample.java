package com.example.tcm_kgsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatLinkExample() {
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

        public Criteria andChatLinkTimeIsNull() {
            addCriterion("chat_link_time is null");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeIsNotNull() {
            addCriterion("chat_link_time is not null");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeEqualTo(Date value) {
            addCriterion("chat_link_time =", value, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeNotEqualTo(Date value) {
            addCriterion("chat_link_time <>", value, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeGreaterThan(Date value) {
            addCriterion("chat_link_time >", value, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("chat_link_time >=", value, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeLessThan(Date value) {
            addCriterion("chat_link_time <", value, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeLessThanOrEqualTo(Date value) {
            addCriterion("chat_link_time <=", value, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeIn(List<Date> values) {
            addCriterion("chat_link_time in", values, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeNotIn(List<Date> values) {
            addCriterion("chat_link_time not in", values, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeBetween(Date value1, Date value2) {
            addCriterion("chat_link_time between", value1, value2, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkTimeNotBetween(Date value1, Date value2) {
            addCriterion("chat_link_time not between", value1, value2, "chatLinkTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeIsNull() {
            addCriterion("chat_link_last_time is null");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeIsNotNull() {
            addCriterion("chat_link_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeEqualTo(Date value) {
            addCriterion("chat_link_last_time =", value, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeNotEqualTo(Date value) {
            addCriterion("chat_link_last_time <>", value, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeGreaterThan(Date value) {
            addCriterion("chat_link_last_time >", value, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("chat_link_last_time >=", value, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeLessThan(Date value) {
            addCriterion("chat_link_last_time <", value, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("chat_link_last_time <=", value, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeIn(List<Date> values) {
            addCriterion("chat_link_last_time in", values, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeNotIn(List<Date> values) {
            addCriterion("chat_link_last_time not in", values, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeBetween(Date value1, Date value2) {
            addCriterion("chat_link_last_time between", value1, value2, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andChatLinkLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("chat_link_last_time not between", value1, value2, "chatLinkLastTime");
            return (Criteria) this;
        }

        public Criteria andFromWindowIsNull() {
            addCriterion("from_window is null");
            return (Criteria) this;
        }

        public Criteria andFromWindowIsNotNull() {
            addCriterion("from_window is not null");
            return (Criteria) this;
        }

        public Criteria andFromWindowEqualTo(Integer value) {
            addCriterion("from_window =", value, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowNotEqualTo(Integer value) {
            addCriterion("from_window <>", value, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowGreaterThan(Integer value) {
            addCriterion("from_window >", value, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_window >=", value, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowLessThan(Integer value) {
            addCriterion("from_window <", value, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowLessThanOrEqualTo(Integer value) {
            addCriterion("from_window <=", value, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowIn(List<Integer> values) {
            addCriterion("from_window in", values, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowNotIn(List<Integer> values) {
            addCriterion("from_window not in", values, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowBetween(Integer value1, Integer value2) {
            addCriterion("from_window between", value1, value2, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andFromWindowNotBetween(Integer value1, Integer value2) {
            addCriterion("from_window not between", value1, value2, "fromWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowIsNull() {
            addCriterion("to_window is null");
            return (Criteria) this;
        }

        public Criteria andToWindowIsNotNull() {
            addCriterion("to_window is not null");
            return (Criteria) this;
        }

        public Criteria andToWindowEqualTo(Integer value) {
            addCriterion("to_window =", value, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowNotEqualTo(Integer value) {
            addCriterion("to_window <>", value, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowGreaterThan(Integer value) {
            addCriterion("to_window >", value, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_window >=", value, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowLessThan(Integer value) {
            addCriterion("to_window <", value, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowLessThanOrEqualTo(Integer value) {
            addCriterion("to_window <=", value, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowIn(List<Integer> values) {
            addCriterion("to_window in", values, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowNotIn(List<Integer> values) {
            addCriterion("to_window not in", values, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowBetween(Integer value1, Integer value2) {
            addCriterion("to_window between", value1, value2, "toWindow");
            return (Criteria) this;
        }

        public Criteria andToWindowNotBetween(Integer value1, Integer value2) {
            addCriterion("to_window not between", value1, value2, "toWindow");
            return (Criteria) this;
        }

        public Criteria andFromUnreadIsNull() {
            addCriterion("from_unread is null");
            return (Criteria) this;
        }

        public Criteria andFromUnreadIsNotNull() {
            addCriterion("from_unread is not null");
            return (Criteria) this;
        }

        public Criteria andFromUnreadEqualTo(Integer value) {
            addCriterion("from_unread =", value, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadNotEqualTo(Integer value) {
            addCriterion("from_unread <>", value, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadGreaterThan(Integer value) {
            addCriterion("from_unread >", value, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_unread >=", value, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadLessThan(Integer value) {
            addCriterion("from_unread <", value, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadLessThanOrEqualTo(Integer value) {
            addCriterion("from_unread <=", value, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadIn(List<Integer> values) {
            addCriterion("from_unread in", values, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadNotIn(List<Integer> values) {
            addCriterion("from_unread not in", values, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadBetween(Integer value1, Integer value2) {
            addCriterion("from_unread between", value1, value2, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andFromUnreadNotBetween(Integer value1, Integer value2) {
            addCriterion("from_unread not between", value1, value2, "fromUnread");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusIsNull() {
            addCriterion("chat_link_status is null");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusIsNotNull() {
            addCriterion("chat_link_status is not null");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusEqualTo(Integer value) {
            addCriterion("chat_link_status =", value, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusNotEqualTo(Integer value) {
            addCriterion("chat_link_status <>", value, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusGreaterThan(Integer value) {
            addCriterion("chat_link_status >", value, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_link_status >=", value, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusLessThan(Integer value) {
            addCriterion("chat_link_status <", value, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("chat_link_status <=", value, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusIn(List<Integer> values) {
            addCriterion("chat_link_status in", values, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusNotIn(List<Integer> values) {
            addCriterion("chat_link_status not in", values, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusBetween(Integer value1, Integer value2) {
            addCriterion("chat_link_status between", value1, value2, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andChatLinkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_link_status not between", value1, value2, "chatLinkStatus");
            return (Criteria) this;
        }

        public Criteria andToUnreadIsNull() {
            addCriterion("to_unread is null");
            return (Criteria) this;
        }

        public Criteria andToUnreadIsNotNull() {
            addCriterion("to_unread is not null");
            return (Criteria) this;
        }

        public Criteria andToUnreadEqualTo(Integer value) {
            addCriterion("to_unread =", value, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadNotEqualTo(Integer value) {
            addCriterion("to_unread <>", value, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadGreaterThan(Integer value) {
            addCriterion("to_unread >", value, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_unread >=", value, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadLessThan(Integer value) {
            addCriterion("to_unread <", value, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadLessThanOrEqualTo(Integer value) {
            addCriterion("to_unread <=", value, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadIn(List<Integer> values) {
            addCriterion("to_unread in", values, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadNotIn(List<Integer> values) {
            addCriterion("to_unread not in", values, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadBetween(Integer value1, Integer value2) {
            addCriterion("to_unread between", value1, value2, "toUnread");
            return (Criteria) this;
        }

        public Criteria andToUnreadNotBetween(Integer value1, Integer value2) {
            addCriterion("to_unread not between", value1, value2, "toUnread");
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