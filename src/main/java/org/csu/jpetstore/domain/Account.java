package org.csu.jpetstore.domain;

import lombok.Data;
import org.csu.jpetstore.common.validation.EnumValue;
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
    @EnumValue(enumClass = UserStatusEnum.class, enumMethod = "isValidName", groups = CreateGroup.class)
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
     * 用户状态枚举
     */
    public enum UserStatusEnum {
        /**
         * 正常的
         */
        NORMAL(1, "Normal"),
        /**
         * 禁用的
         */
        DISABLED(2, "Disable"),
        /**
         * 已删除的
         */
        DELETED(3, "Deleted");

        private int code;
        private String value;

        UserStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        /**
         * 判断参数合法性
         */
        public static boolean isValidName(String code) {
            for (UserStatusEnum userStatusEnum : UserStatusEnum.values()) {
                if (userStatusEnum.getCode() == Integer.parseInt(code)) {
                    return true;
                }
            }
            return false;
        }
    }

}
