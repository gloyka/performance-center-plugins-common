/**
 * Copyright © 2023 Open Text Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;

public class TimeInterval {
    @SuppressWarnings("unused")
    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    private boolean daysSpecified;
    private boolean hoursSpecified;
    private boolean minutesSpecified;
    private boolean secondsSpecified;

    public TimeInterval(int days, int hours, int minutes, int seconds, boolean daysSpecified,
                        boolean hoursSpecified, boolean minutesSpecified, boolean secondsSpecified) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.daysSpecified = daysSpecified;
        this.hoursSpecified = hoursSpecified;
        this.minutesSpecified = minutesSpecified;
        this.secondsSpecified = secondsSpecified;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean isDaysSpecified() {
        return daysSpecified;
    }

    public void setDaysSpecified(boolean daysSpecified) {
        this.daysSpecified = daysSpecified;
    }

    public boolean isHoursSpecified() {
        return hoursSpecified;
    }

    public void setHoursSpecified(boolean hoursSpecified) {
        this.hoursSpecified = hoursSpecified;
    }

    public boolean isMinutesSpecified() {
        return minutesSpecified;
    }

    public void setMinutesSpecified(boolean minutesSpecified) {
        this.minutesSpecified = minutesSpecified;
    }

    public boolean isSecondsSpecified() {
        return secondsSpecified;
    }

    public void setSecondsSpecified(boolean secondsSpecified) {
        this.secondsSpecified = secondsSpecified;
    }
}
