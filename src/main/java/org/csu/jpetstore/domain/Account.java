package org.csu.jpetstore.domain;

import lombok.Data;
import org.csu.jpetstore.common.validation.groups.CreateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 8751282105532159742L;

    @NotBlank
    @Length(min = 1, max = 64, groups = CreateGroup.class)
    private String username;
    @NotBlank
    @Length(min = 6, max = 16, groups = CreateGroup.class, message = "{custom.pwd.invalid}")
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String status;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "{custom.phone.invalid}", groups = CreateGroup.class)
    private String phone;
    private String favouriteCategoryId;
    private String languagePreference;
    private boolean listOption;
    private boolean bannerOption;
    private String bannerName;
    private boolean authenticated;

    /**
     * 账号状态枚举
     */
    public enum StatusEnum {
        NORMAL(0, "正常"),
        SUSPENDED(1, "停用"),
        DELETED(2, "已删除");

        private Integer code;
        private String desc;

        StatusEnum(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static boolean isValidCode(Integer code) {

            if (code == null) {
                return false;
            }

            for (StatusEnum status : StatusEnum.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }

    }
}
