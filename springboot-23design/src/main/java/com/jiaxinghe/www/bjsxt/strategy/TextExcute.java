package com.jiaxinghe.www.bjsxt.strategy;

public class TextExcute {
    public static void main(String[] args) {
        String  text = "['0632', '0539', '0537', '0516', '0531', '0532']" +
                "['010', '0316', '0312', '022', '0314', '0313']" +
                "['022', '010', '0316', '0312', '0317', '0315']" +
                "['029', '0910', '0913', '0914', '0915', '0919']" +
                "['0349', '0352', '0351', '010', '0350', '0471']" +
                "['0532', '0536', '0535', '0539', '0531', '0633']" +
                "['0536', '0532', '0531', '0535', '0539', '0533']" +
                "['0539', '0531', '0532', '0536', '0632', '0633']" +
                "['0543', '0531', '0533', '0536', '010', '0532']" +
                "['0553', '0551', '025', '021', '0512', '0555']" +
                "['025', '0551', '0555', '0553', '0512', '021']" +
                "['0557', '0551', '0516', '025', '0512', '0561']" +
                "['0551', '0561', '0557', '0516', '025', '0558']" +
                "['0563', '021', '0571', '0512', '025', '0551']" +
                "['0571', '0575', '0573', '0579', '021', '0572']" +
                "['0592', '0595', '0596', '0594', '0591', '0598']" +
                "['0594', '0591', '0595', '0592', '0596', '0593']" +
                "['0595', '0592', '0591', '0594', '0596', '0598']" +
                "['0597', '0592', '0595', '0596', '0591', '0753']" +
                "['0631', '0535', '0532', '0536', '0531', '0533']" +
                "['027', '0712', '0722', '0713', '0716', '0715']" +
                "['0722', '027', '0712', '0710', '0716', '0376']" +
                "['0734', '0731', '020', '0769', '0732', '0746']" +
                "['0752', '0755', '0769', '020', '0762', '0757']" +
                "['0754', '0663', '020', '0768', '0755', '0752']" +
                "['0756', '0760', '020', '0755', '0769', '0750']" +
                "['020', '0763', '0757', '0769', '0755', '0760']" +
                "['0772', '1772', '0778', '0773', '0769', '0771']" +
                "['0335', '010', '0315', '0316', '022', '0314']" +
                "['0351', '0354', '0358', '0353', '010', '0311']" +
                "['0358', '0351', '0354', '010', '0357', '0371']" +
                "['0359', '0371', '0357', '0398', '010', '0913']" +
                "['0371', '0378', '0374', '0373', '0394', '0379']" +
                "['0373', '0371', '0378', '0391', '0372', '0393']" +
                "['0371', '0391', '0379', '0373', '0372', '0393']" +
                "['0392', '0371', '0372', '0393', '0373', '0391']" +
                "['0396', '0371', '0376', '0394', '0377', '0395']" +
                "['0412', '024', '0411', '010', '0417', '0415']" +
                "['024', '0413', '0411', '0412', '0414', '0417']" +
                "['024', '0414', '0411', '0412', '0413', '0419']" +
                "['0427', '024', '0411', '0416', '0417', '0412']" +
                "['0429', '010', '024', '0416', '0335', '0421']" +
                "['0431', '0432', '024', '0435', '0451', '0438']" +
                "['0432', '0431', '0451', '024', '010', '0435']" +
                "['0451', '0455', '0452', '0459', '0431', '0453']" +
                "['0452', '0451', '0459', '0455', '0470', '0431']" +
                "['0531', '0534', '0538', '0537', '0533', '0536']" +
                "['0533', '0531', '0543', '0536', '0539', '0532']" +
                "['0531', '0534', '010', '0543', '0635', '022']" +
                "['0552', '0551', '025', '0550', '1558', '0554']" +
                "['0551', '0554', '021', '0552', '0564', '025']" +
                "['0558', '0551', '1558', '025', '0552', '0557']" +
                "['0562', '0551', '0553', '0556', '025', '0566']" +
                "['0551', '0564', '0512', '1558', '021', '025']" +
                "['0591', '0594', '0595', '0593', '0592', '0599']" +
                "['027', '0715', '0714', '0730', '0731', '0711']" +
                "['0776', '0771', '0769', '0778', '1771', '0755']" +
                "['0779', '0759', '0775', '0769', '0668', '0777']" +
                "['0817', '028', '023', '0816', '0826', '0838']" +
                "['028', '0832', '023', '1832', '1833', '0825']" +
                "['0873', '0871', '0874', '0877', '0876', '0879']" +
                "['0871', '0874', '0873', '0870', '0876', '0877']" +
                "['0898', '0759', '0899', '0805', '0804', '0668']" +
                "['0910', '029', '0913', '0915', '0919', '0914']" +
                "['0319', '0311', '010', '0310', '0312', '0318']" +
                "['0318', '0311', '010', '0312', '0317', '0316']" +
                "['0351', '0354', '0350', '010', '0358', '0355']" +
                "['0352', '010', '0349', '0351', '022', '0312']" +
                "['0353', '0351', '0311', '0660', '0354', '010']" +
                "['0372', '0371', '0393', '0392', '0373', '0378']" +
                "['0371', '0374', '0375', '0394', '0395', '0379']" +
                "['0376', '0371', '027', '0396', '0551', '0564']" +
                "['0371', '0378', '0394', '0373', '0370', '0374']" +
                "['0371', '0393', '0372', '0392', '0531', '0373']" +
                "['0416', '024', '0411', '0429', '0418', '0421']" +
                "['0482', '0455', '010', '0436', '0451', '0452']" +
                "['0515', '0512', '021', '025', '0510', '0513']" +
                "['025', '0551', '0550', '0512', '021', '0552']" +
                "['0551', '0556', '0571', '027', '025', '021']" +
                "['0559', '0571', '0551', '025', '0579', '021']" +
                "['0551', '0566', '0556', '0571', '021', '025']" +
                "['0575', '0571', '0574', '0579', '021', '0573']" +
                "['0576', '0577', '0571', '0579', '0574', '021']" +
                "['0577', '0576', '0571', '0579', '0578', '021']" +
                "['0591', '0593', '0577', '0595', '0599', '0592']" +
                "['0596', '0592', '0595', '0591', '0754', '0594']" +
                "['0598', '0595', '0592', '0591', '0599', '0596']" +
                "['0599', '0591', '0595', '0592', '0598', '0593']" +
                "['0660', '0755', '020', '0752', '0769', '0663']" +
                "['0668', '020', '0769', '0755', '0759', '0757']" +
                "['0691', '0879', '0871', '0883', '0873', '0877']" +
                "['0692', '0875', '0872', '0871', '0883', '0878']" +
                "['0701', '0793', '0791', '0794', '0797', '0798']" +
                "['028', '0834', '0833', '0812', '1833', '0835']" +
                "['0851', '0852', '0854', '0853', '0857', '0856']" +
                "['0855', '0851', '0854', '0856', '0852', '0769']" +
                "['0856', '0851', '0852', '023', '0855', '0743']" +
                "['0317', '010', '0311', '022', '0312', '0316']" +
                "['0351', '0350', '010', '022', '0352', '0349']" +
                "['0370', '0371', '0394', '0530', '0378', '0516']" +
                "['0395', '0371', '0394', '0374', '0396', '0375']" +
                "['0773', '0769', '0755', '020', '0746', '0772']" +
                "['0775', '0769', '0755', '020', '0757', '0760']" +
                "['0790', '0795', '0796', '0791', '0797', '0755']" +
                "['0794', '0791', '0797', '0796', '0769', '0755']" +
                "['028', '0812', '0834', '0871', '1833', '0835']" +
                "['0818', '023', '028', '0817', '0826', '0827']" +
                "['028', '0827', '023', '0817', '0818', '0816']" +
                "['028', '0833', '1833', '0834', '023', '0813']" +
                "['028', '0835', '1833', '0833', '0834', '0838']" +
                "['028', '0838', '0816', '0817', '023', '0825']" +
                "['028', '0839', '0817', '0816', '0827', '023']" +
                "['0852', '0851', '023', '0857', '0856', '0854']" +
                "['0851', '0853', '0859', '0857', '0858', '0854']" +
                "['0851', '0854', '0855', '0852', '0859', '0853']" +
                "['0859', '0851', '0858', '0853', '0871', '0874']" +
                "['0870', '0871', '0874', '028', '0831', '023']" +
                "['0871', '0874', '0877', '0873', '0878', '0879']" +
                "['0994', '0991', '0993', '0901', '1994', '0995']" +
                "['0771', '1771', '0776', '0769', '0668', '0759']" +
                "['1937', '0937', '0483', '0936', '0931', '0473']" +
                "['0415', '024', '0411', '010', '0412', '0417']" +
                "['0417', '024', '0411', '0412', '0427', '010']" +
                "['0418', '024', '0416', '0411', '025', '0427']" +
                "['0451', '0455', '0459', '0452', '0453', '0432']" +
                "['0471', '0472', '0477', '0474', '010', '0352']" +
                "['0474', '0471', '010', '0352', '0313', '0311']" +
                "['0477', '0472', '0471', '0912', '0951', '0478']" +
                "['0510', '0512', '0519', '0515', '021', '0523']" +
                "['0511', '025', '0514', '0519', '0515', '0512']" +
                "['0512', '021', '0510', '0515', '0513', '0571']" +
                "['0513', '021', '0512', '0510', '025', '0515']" +
                "['0514', '025', '0512', '0523', '0511', '021']" +
                "['0516', '025', '0527', '0512', '0518', '0517']" +
                "['0519', '0510', '0512', '025', '0515', '0523']" +
                "['0523', '0512', '025', '0510', '021', '0514']" +
                "['0530', '0531', '0537', '0371', '0370', '0516']" +
                "['0537', '0531', '0530', '0538', '0539', '0632']" +
                "['0531', '0538', '0537', '0539', '0530', '0532']" +
                "['0551', '0564', '0556', '0554', '0550', '0552']" +
                "['0717', '027', '0716', '0724', '0710', '023']" +
                "['0872', '0871', '0888', '0875', '0883', '0692']" +
                "['0912', '0477', '0951', '0351', '0911', '029']" +
                "['0472', '0477', '0471', '027', '0478', '010']" +
                "['0478', '0472', '0471', '0477', '0951', '0473']" +
                "['0527', '025', '0512', '0517', '0516', '0510']" +
                "['0570', '0571', '0579', '0574', '0575', '0576']" +
                "['0579', '0571', '0574', '0575', '0576', '0577']" +
                "['0574', '0580', '0571', '021', '0512', '0579']" +
                "['0633', '0532', '0539', '0531', '0536', '0518']" +
                "['027', '0711', '0713', '0714', '0715', '0712']" +
                "['027', '0713', '0714', '0711', '0792', '0712']" +
                "['0716', '027', '0730', '0724', '0731', '0717']" +
                "['0719', '027', '0710', '0716', '0717', '0377']" +
                "['0731', '0733', '0732', '0734', '0739', '0738']" +
                "['0745', '0743', '0731', '0744', '0856', '0736']" +
                "['0744', '0731', '0743', '0736', '0730', '0738']" +
                "['0745', '0731', '0743', '0739', '0736', '0769']" +
                "['0750', '020', '0757', '0760', '0755', '0769']" +
                "['0751', '020', '0755', '0769', '0757', '0763']" +
                "['020', '0755', '0753', '0769', '0752', '0757']" +
                "['0755', '0769', '020', '0752', '0757', '0760']" +
                "['0758', '0757', '020', '0769', '0755', '0760']" +
                "['0755', '0762', '020', '0752', '0769', '0757']" +
                "['0768', '0754', '0663', '020', '0769', '0755']" +
                "['0770', '0771', '0777', '0759', '0775', '0779']" +
                "['0771', '1771', '0775', '0777', '0759', '0769']" +
                "['0777', '0771', '0769', '0775', '0759', '020']" +
                "['0778', '0771', '0772', '0769', '0755', '0776']" +
                "['0791', '0795', '0792', '0794', '0793', '0798']" +
                "['0792', '0791', '0713', '0556', '027', '0755']" +
                "['0793', '0791', '0571', '0579', '0798', '0701']" +
                "['0796', '0755', '0769', '0797', '0791', '020']" +
                "['0797', '0755', '020', '0769', '0752', '0757']" +
                "['0791', '0798', '0793', '0571', '0792', '0579']" +
                "['028', '0813', '1832', '023', '0831', '0830']" +
                "['028', '0825', '023', '0832', '1832', '0817']" +
                "['0769', '0755', '020', '0757', '0752', '0760']" +
                "['0998', '0997', '0903', '0908', '0999', '1998']" +
                "['0572', '0571', '021', '0512', '0573', '0510']" +
                "['020', '0769', '0757', '0755', '0752', '0760']" +
                "['023', '028', '0826', '0817', '0830', '0818']" +
                "['021', '0512', '0513', '0571', '0573', '0515']" +
                "['024', '0413', '0412', '0410', '0414', '0419']" +
                "['027', '0713', '0712', '0714', '0711', '0716']" +
                "['028', '0838', '1833', '0832', '0816', '023']" +
                "['025', '0515', '0514', '0517', '0523', '0511']" +
                "['0315', '010', '022', '0316', '0312', '0314']" +
                "['0310', '0311', '010', '0319', '0531', '0635']" +
                "['0311', '0312', '010', '0319', '0317', '0316']" +
                "['0312', '010', '0311', '0316', '0317', '022']" +
                "['0573', '0571', '021', '0512', '0574', '0572']" +
                "['0574', '0571', '021', '0580', '0512', '0579']" +
                "['0578', '0577', '0571', '0579', '0576', '0574']" +
                "['0531', '0635', '0534', '0537', '0538', '0310']" +
                "['0662', '020', '0769', '0755', '0757', '0760']" +
                "['0663', '020', '0754', '0755', '0769', '0752']" +
                "['0710', '027', '0716', '0377', '0724', '0719']" +
                "['0736', '0731', '0730', '0737', '0739', '0716']" +
                "['0731', '0737', '0730', '0736', '0732', '0733']" +
                "['0757', '020', '0769', '0755', '0760', '0758']" +
                "['0759', '020', '0668', '0755', '0769', '0757']" +
                "['0760', '020', '0757', '0769', '0755', '0756']" +
                "['020', '0766', '0757', '0769', '0755', '0758']" +
                "['0769', '0755', '020', '0752', '0757', '0760']" +
                "['0774', '0769', '0757', '020', '0755', '0760']" +
                "['0795', '0791', '0796', '0755', '0731', '0797']" +
                "['0799', '0736']" +
                "['028', '0816', '0838', '0817', '023', '0825']" +
                "['0893', '0891', '0892', '0894', '0931', '0896']" +
                "['010', '0313', '0312', '0311', '0316', '022']" +
                "['010', '0316', '022', '0312', '0311', '0317']" +
                "['010', '0314', '022', '0316', '0315', '0335']" +
                "['0356', '0371', '0351', '0357', '0379', '0359']" +
                "['0357', '0371', '010', '0351', '0359', '0356']" +
                "['0371', '0375', '0374', '0379', '0395', '0377']" +
                "['0377', '0371', '0710', '0379', '0396', '0375']" +
                "['0379', '0371', '0375', '0377', '0391', '0398']" +
                "['0899', '0898', '0809', '0668', '0759', '0801']" +
                "['0914', '0910', '029', '0913', '0719', '0377']" +
                "['029', '0917']" +
                "['023', '0826', '028', '0817', '0816', '0818']" +
                "['028', '0830', '023', '0831', '1832', '0813']" +
                "['0831', '028', '023', '0830', '0813', '1832']" +
                "['0857', '0851', '0852', '0858', '0870', '023']" +
                "['0858', '0857', '0851', '0859', '0852', '0874']" +
                "['0871', '0878', '0872', '0877', '0875', '0883']" +
                "['0883', '0871', '0872', '0875', '0879', '0691']" +
                "['0876', '0871', '0873', '0874', '0877', '0879']" +
                "['0394', '0371', '0395', '0370', '0378', '0396']" +
                "['0398', '0371', '0379', '0359', '0377', '0375']" +
                "['024', '0410', '010', '0413', '0414', '0418']" +
                "['0411', '024', '0412', '0415', '0417', '0416']" +
                "['0453', '0451', '0467', '1433', '0431', '024']" +
                "['0459', '0451', '0455', '0452', '0431', '0438']" +
                "['010', '0476', '022', '0316', '0315', '0314']" +
                "['0517', '025', '0512', '021', '0510', '0515']" +
                "['0518', '025', '0512', '021', '0515', '0517']" +
                "['0535', '0532', '0536', '0631', '0531', '0539']" +
                "['027', '0714', '0713', '0711', '0715', '0712']" +
                "['027', '0724', '0716', '0717', '0710', '0712']" +
                "['0731', '0730', '0716', '0736', '0737', '0733']" +
                "['0731', '0732', '0733', '0734', '0738', '0737']" +
                "['0731', '0732', '0733', '0730', '0737', '0734']" +
                "['0735', '0769', '020', '0755', '0731', '0746']" +
                "['0731', '0738', '0734', '0739', '0736', '0732']" +
                "['0739', '0731', '0769', '0755', '0734', '0746']" +
                "['0746', '0769', '020', '0755', '0731', '0735']" +
                "['0871', '0879', '0691', '0877', '0873', '0883']" +
                "['0913', '0910', '029', '0919', '0359', '0914']" +
                "['0910', '0913', '0919', '029', '0911', '0914']" +
                "['0951', '0952', '0953', '0931', '0912', '1953']" +
                "['0991', '0994', '1994', '0990', '0993', '0901']" +
                "['1755', '0769', '0760', '0757', '020', '0755']" +
                "['1772', '0769', '0772', '0771', '0755', '1755']" +
                "['0875', '0871', '0872', '0692', '0883', '0878']" +
                "['0871', '0877', '0879', '0873', '0874', '0878']" +
                "['0888', '0872', '0871', '0887', '0834', '0875']" +
                "['0891', '0892', '0893', '0757', '0769', '0755']" +
                "['0916', '0910', '0827', '0915', '028', '0818']" +
                "['0931', '0971', '0943', '0932', '0951', '0930']" +
                "['0937', '1937', '0483', '0936', '0931', '0971']" +
                "['0972', '0971', '0931', '0974', '0970', '0977']" +
                "['1558', '0551', '0558', '021', '025', '0564']" +
                "['1774', '0769', '0755', '0757', '020', '0760']" +
                "['028', '1832', '023', '0832', '0813', '0830']" +
                "['028', '1833', '1832', '0832', '0833', '0813']";
        System.out.println(text);
    }

}
