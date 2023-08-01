package cn.hjk.reggie.dto;

import cn.hjk.reggie.entity.Setmeal;
import cn.hjk.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
