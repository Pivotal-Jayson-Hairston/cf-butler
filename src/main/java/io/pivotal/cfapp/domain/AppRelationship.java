package io.pivotal.cfapp.domain;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor(access=AccessLevel.PACKAGE)
@NoArgsConstructor(access=AccessLevel.PACKAGE)
@ToString
public class AppRelationship {

	private String organization;
    private String space;
    private String appId;
    private String appName;
    private String serviceId;
    private String serviceName;
    private String servicePlan;
    private String serviceType;
    
    public static String headers() {
        return String.join(",", "organization", "space", "application id",
                "application name", "service id", "service name", "service plan", "service type");
    }
    
    public String toCsv() {
        return String
                .join(",", wrap(getOrganization()), wrap(getSpace()), wrap(getAppId()),
                        wrap(getAppName()), wrap(getServiceId()), wrap(getServiceName()),
                        wrap(getServicePlan()), wrap(getServiceType()));
    }
    
    private String wrap(String value) {
        return value != null ? StringUtils.wrap(value, '"') : StringUtils.wrap("", '"');
    }
}
