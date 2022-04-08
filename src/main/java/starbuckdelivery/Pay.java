package starbuckdelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Pay_table")
public class Pay  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String customerId;

    private String productId;

    private String option;

    private String status;


    @PostPersist
    public void onPostPersist(){
        Paid paid = new Paid();
        BeanUtils.copyProperties(this, paid);
        paid.publishAfterCommit();

    }
//     @PostPersist
//     public void onPostPersist(){
//         ////////////////////////////
//         // 결제 승인 된 경우
//         ////////////////////////////

//         // 이벤트 발행 -> PaymentApproved
//         PaymentApproved paymentApproved = new PaymentApproved();
//         BeanUtils.copyProperties(this, paymentApproved);
//         paymentApproved.publishAfterCommit();
//     }

//     @PostUpdate
//     public void onPostUpdate(){

//         //////////////////////
//         // 결제 취소 된 경우
//         //////////////////////

//         // 이벤트 발행 -> PaymentCancelled
//         PaymentCancelled paymentCancelled = new PaymentCancelled();
//         BeanUtils.copyProperties(this, paymentCancelled);
//         paymentCancelled.publishAfterCommit();

//     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    



}
