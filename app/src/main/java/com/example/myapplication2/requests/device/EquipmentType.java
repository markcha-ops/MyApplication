package com.example.myapplication2.requests.device;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EquipmentType {
    AirCompressor("에어 컴프레셔", "airCompressor"),
    PowerMeter("전력계", "power"),
    PressureGauger("압력계", "pressure"),
    FlowMeter("유량계", "flow"),
    ThemoMeter("온도계", "temperature"),
    HygroMeter("습도계", "humidity"),
    ThemoHygroMeter("온습도계", "humtemperature");
    private String description;
    private String nickname;
}
