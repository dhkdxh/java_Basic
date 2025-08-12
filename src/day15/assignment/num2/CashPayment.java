package day15.assignment.num2;

public class CashPayment extends Payment{
    private String cashReceiptNumber;

    public CashPayment(String shopName, String productName, long productPrice, String cashReceiptNumber) {
        super(shopName, productName, productPrice);
        this.cashReceiptNumber = cashReceiptNumber;
    }

    public String toString(){
        return "[ 현금 결제 정보 ]\n상점명 : "+ this.shopName+"\n상품명 : "+this.productName+"\n상품가격 : "+this.productPrice+"\n현금영수증번호 : "+this.cashReceiptNumber;
    }

    @Override
    public void pay() throws PayException {
        if(this.productPrice <= 0){
            throw new PayException("가격이 잘못되었습니다.");
        }
        System.out.println("현금이 정상적으로 지불되었습니다.");
    }
}
