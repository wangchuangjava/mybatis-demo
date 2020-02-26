package cn.job.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: 小组实体
 * @Date: 2019-11-28 14:27
 * @Description: < 描述 >
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "c_user_group")
public class Group implements Serializable {
    @Id
    private Integer id;
    private String  groupName;
}
