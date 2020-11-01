//package com.xingjiahe.www.infrastructure.util.validator;
//
//import com.google.common.collect.Lists;
//import org.apache.commons.collections.CollectionUtils;
//import org.hibernate.validator.HibernateValidator;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import javax.validation.groups.Default;
//import java.util.List;
//import java.util.Set;
//
///**
// * Description
// * Copyright HelloBike
// *
// * @author limingjun
// * @version 1.0
// * @date 2018/12/13
// */
//public class ValidationUtils {
//
//    private static Validator validator;
//
//    static {
//        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
//                .configure()
//                .buildValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    public static <T> ValidationResult validateEntity(T obj) {
//        ValidationResult result = new ValidationResult();
//        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
//        if (CollectionUtils.isNotEmpty(set)) {
//            result.setHasErrors(true);
//            List<String> errorMsg = Lists.newArrayList();
//            for (ConstraintViolation<T> cv : set) {
//                errorMsg.add(cv.getMessage());
//            }
//            result.setErrorMsg(errorMsg);
//        }
//        return result;
//    }
//
//}
