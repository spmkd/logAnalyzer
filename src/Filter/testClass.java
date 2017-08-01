package Filter;

import java.util.Arrays;


public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = " Exception caught for REST request com.intershop.beehive.orm.capi.common.ORMException: Object is not valid.  com.intershop.beehive.core.capi.domain.PersistentObjectPOKey[xy0KLwSD8d4AAAFaAfBM.u1H]";
		
		String s1 = "Item(s): [item1.test], [item2.qa],[item3.production] ";
				
		String s2 = "Mapped exception to response: 500 (Internal Server Error) com.intershop.component.rest.capi.RestException: Web service pipeline execution: domain [null] pipeline [ProcessCartREST] start node[ AddProducts] finished with exception: com.intershop.beehive.core.capi.pipeline.PipelineExecutionException: com.intershop.beehive.orm.capi.common.ORMException: Could not UPDATE object: com.intershop.beehive.bts.internal.orderprocess.basket.BasketPO[com.intershop.beehive.orm.internal.state.ObjectState@43890f81[type=10, lastTouched=Tue Mar 21 19:59:28 CET 2017, historyDate=null, splitShipmentAllowedFlag=true, sessionBasedFlag=false, creationDate=Tue Mar 21 19:59:28 CET 2017, requestedDeliveryDate=null, status=0, documentNo=-, userID=djcKLwSDt3IAAAFauocLsvI2, leadCurrencyCode=USD, purchaseCurrencyCode=EUR, exchangeRatePTCtoLC=null, exchangeRatePCtoLC=null, exchangeRatePCtoPTC=null, invoiceToAddressID=null, shipFromAddressID=null, grandTotalNetPriceLCCode=N/A, grandTotalNetPriceLCValue=0, grandTotalNetPricePCCode=EUR, grandTotalNetPricePCValue=310.18, grandTotalTaxLCCode=N/A, grandTotalTaxLCValue=0, grandTotalTaxPCCode=EUR, grandTotalTaxPCValue=65.14, grandTotalGrossPriceLCCode=N/A, grandTotalGrossPriceLCValue=0, grandTotalGrossPricePCCode=EUR, grandTotalGrossPricePCValue=375.32, grandTotalGrossPricePTCCode=N/A, grandTotalGrossPricePTCValue=0, buyerNo=null, anonymousFlag=true, sessionID=J80KLwSGlGgAAAFaz_4WZvI8, serviceToAddressID=null, installToAddressID=null, submitDate=null, xmlComputedItems=ComputedItems";
		
		s = s.replaceAll("\\[.*?\\]", "[]");
		
		System.out.println(s);
		
	}

}
