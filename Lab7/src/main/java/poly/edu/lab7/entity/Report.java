package poly.edu.lab7.entity;

import java.io.Serializable;

public interface Report extends Serializable {
    Serializable getGroup();   // group = Category
    Double getSum();           // tổng giá
    Long getCount();           // số lượng sản phẩm
}
