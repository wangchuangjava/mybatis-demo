package cn.job.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: 用户实体
 * @Date: 2019-11-28 11:05
 * @Description: < 描述 >
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "c_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer groupId;
    private String name;
    private String address;
    private Group group;
}
