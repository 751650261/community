package com.cwq.springbootcommunity.enums;

/**
 * @author cwq
 * @date 2019/11/12 - 15:45
 */
public enum NotificationStatusEnum {
    UNREAD(0),READ(1);
    private int status;

    NotificationStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
