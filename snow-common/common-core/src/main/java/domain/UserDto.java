package domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 登录用户信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String clientId;
    private List<String> roles;

}
