--------------------------------------------------------
--  File created - Friday-January-24-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "SHOPPING"."CUSTOMER" 
   (	"CUSTOMER_ID" VARCHAR2(40 CHAR), 
	"FIRST_NAME" VARCHAR2(40 CHAR), 
	"LAST_NAME" VARCHAR2(40 CHAR), 
	"TOTAL_PURCHASES" NUMBER(10,2), 
	"LOYALTY_STATUS" NUMBER(2,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SHOPPING" ;
REM INSERTING into SHOPPING.CUSTOMER
SET DEFINE OFF;
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('rsteven','Robert','Stevenson',2990,1);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('jstein','John','Steinbeck',29930.12,3);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('cdickens','Charles','Dickens',580.99,0);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('mmitch','Margaret','Mitchell',1392.03,1);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('wfaulk','William','Faulk',156.99,0);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('cdoyle','Chris','Doyle',2560.83,1);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('istone','Iriving','Stone',5310.12,2);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('wshake','William','Shakespeare',8738.33,2);
Insert into SHOPPING.CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,TOTAL_PURCHASES,LOYALTY_STATUS) values ('mtwain','Mark','Twain',12998.45,3);
--------------------------------------------------------
--  DDL for Index PK_CUSTOMER
--------------------------------------------------------

  CREATE UNIQUE INDEX "SHOPPING"."PK_CUSTOMER" ON "SHOPPING"."CUSTOMER" ("CUSTOMER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SHOPPING" ;
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "SHOPPING"."CUSTOMER" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
  ALTER TABLE "SHOPPING"."CUSTOMER" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "SHOPPING"."CUSTOMER" ADD CONSTRAINT "PK_CUSTOMER" PRIMARY KEY ("CUSTOMER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SHOPPING"  ENABLE;
