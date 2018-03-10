
package jsat.math;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edward Raff
 */
public class SpecialMathTest
{
    
    public SpecialMathTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }



    /**
     * Test of digamma method, of class SpecialMath.
     */
    @Test
    public void testZeta()
    {
        System.out.println("digamma");
        
        //Values in this range have crappy accuracy... sad panda
        
        double[] inputNW = new double[]
        {
            -10.5, -2, -1.5,
        };
        
        double[] expectedNW = new double[]
        {
            0.01114612247394282,0.,-0.02548520188983304,
        };
        
        for(int i = 0; i < inputNW.length; i++)
        {
            assertEquals(expectedNW[i], SpecialMath.zeta(inputNW[i]), 1e-01);
        }
        
        //Decent
        double[] input = new double[]
        {
            -0.5, 0.2, 0.5, 0.9, 1.1, 1.3, 2,
        };
        double[] expected = new double[]
        {
            -0.2078862249773546,-0.7339209248963376,-1.460354508809586,
            -9.43011401940225,10.5844484649508,3.931949211809544,
            1.644934066848226
        };
        
        
        for(int i = 0; i < input.length; i++)
        {
            assertEquals(expected[i], SpecialMath.zeta(input[i]), 1e-5);
        }
        
        
        //Very good
        double[] inputVG = new double[]
        {
             2.6, 10.4, 15, 20, 40.0, 60
        };
        double[] expectedVG = new double[]
        {
            1.305477809072781,1.000751620674465,1.000030588236307,
            1.000000953962033,1.00000000000091,0.999999999999997
        };
        for(int i = 0; i < expectedVG.length; i++)
        {
            assertEquals(expectedVG[i], SpecialMath.zeta(inputVG[i]), 1e-14);
        }
    }
    
    @Test
    public void testHurwitzZeta()
    {
        System.out.println("HurwitzZeta");
        
        double[] qs = new double[]{0.1,0.5,1.0, 2.0, 5.0, 10.0, 100.0, 10000.0,100000000.0};
        
        Map<Double, double[]> map = new HashMap<>();
        map.put(0.01, new double[]{0.4135031309122915871814466,-0.003542397054926171240976755,-0.5092907140398399251076769,-1.509290714039839925107677,-4.477689918142405712644403,-9.382383020520118632585454,-95.98639332666748108896203,-9211.774695069066011783676,-8.401654211974144839796459e7});
        map.put(0.1, new double[]{0.5508589422893526431278708,-0.04328209083938110987506565,-0.6030375198562417152484319,-1.603037519856241715248432,-4.302579534529935464893352,-8.428043471238167390580088,-69.79084035709398376328899,-4423.213952232936729043897,-1.760992428143437908820468e7});
        map.put(0.5, new double[]{1.576009382524539159782465,-0.6048986434216303702472659,-1.460354508809586812889499,-2.460354508809586812889499,-4.244811559185760101799492,-6.165124642085415380195813,-19.94995833359374023524766,-199.9949999583333333593750,-19999.99994999999995833333});
        map.put(1.01, new double[]{110.6568481839125712993911,101.9770931774823586151860,100.5779433384968724902822,99.57794333849687249028215,98.50514757993095784192333,97.77340563917338495320170,95.50404160284692200556433,91.20112953690055112993359,83.17637711442591947918317});
        map.put(1.1, new double[]{23.01457794082749630826599,12.10381349568375510570908,10.58444846495080982638640,9.584448464950809826386401,8.601641508411454352102559,7.983726107059952909313114,6.312734015237240353721934,3.981091611258431755176483,1.584893193253560082885477});
        map.put(2.1, new double[]{127.2351760461769027201376,5.128578172173721239121165,1.560216533503362083710517,0.5602165335033620837105168,0.1729979354308455605161300,0.07632201400329205588192001,0.005767634141331303191670303,0.00003619355156493036316464807,1.440812001070932794770381e-9});
        map.put(5.1, new double[]{125893.1832634196823843001,34.43501603285013348978806,1.034185474687489623326334,0.03418547468748962332633402,0.0004909748162989681064386678,0.00002368069483671087773852296,1.570736357133068259385718e-9,9.711921694158002793357229e-18,3.865593231588839528835528e-34});
        map.put(10.1, new double[]{1.258925411832412651236312e10,1097.512777261824570339265,1.000927273424515647245772,0.0009272734245156472457716332,1.050368145259780612947234e-7,1.335473778753137763579056e-10,7.254385233733663310412230e-20,4.376794942942748506660889e-38,1.741640950081049402284479e-74});
        map.put(100.1, new double[]{1.258925411794167210423954e100,1.358634273092819767285223e30,1.000000000000000000000000,7.360332503047945466884606e-31,1.079201576577305340846106e-70,7.943853383747731139721367e-101,1.003915595723878904182365e-200,0.0,0.0});
//        
//        map.put(-1., new double[]{-0.03833333333333333333333333,0.04166666666666666666666667,-0.08333333333333333333333333,-1.083333333333333333333333,-10.08333333333333333333333,-45.08333333333333333333333,-4950.083333333333333333333,-4.999500008333333333333333e7,-4.999999950000000083333333e15});
//        map.put(-2., new double[]{-0.01200000000000000000000000,0,0,-1.000000000000000000000000,-30.00000000000000000000000,-285.0000000000000000000000,-328350.0000000000000000000,-3.332833350000000000000000e11,-3.333333283333333500000000e23});
//        map.put(-5., new double[]{-0.003171753968253968253968254,0.003844246031746031746031746,-0.003968253968253968253968254,-1.003968253968253968253968,-1300.003968253968253968254,-120825.0039682539682539683,-1.617083325000039682539683e11,-1.666166708333333250000000e23,-1.666666616666667083333333e47});
        
        for(Map.Entry<Double, double[]> entry : map.entrySet())
        {
            double x = entry.getKey();
//            System.out.println("x=" + x);
            for(int i = 0; i < qs.length; i++)
            {
                double q = qs[i];
                double expected = entry.getValue()[i];
                double actual = SpecialMath.zeta(x, q);
                double err;
                if(expected > 0)
                    err = Math.abs((expected-actual)/expected);//relative error
                else//absolute error
                    err = Math.abs(expected-actual);
//                System.out.println("\t" + err);
                assertEquals(0, err, 1e-3);
            }
        }
    }
    
    /**
     * Test of digamma method, of class SpecialMath.
     */
    @Test
    public void testDigamma()
    {
        System.out.println("digamma");
        double[] input = new double[]
        {
            -77.5, -1.5, 1, 1.4, 2, 5, 6, 9, 20, 100
        };
        double[] expected = new double[]
        {
            4.356715675057194,0.7031566406452434,-0.5772156649015328,
            -0.0613845445851161,0.4227843350984672,1.506117668431801,
            1.7061176684318,2.14064147795561,2.97052399224215,4.600161852738087
        };
        for(int i = 0; i < input.length; i++)
            assertEquals(expected[i], SpecialMath.digamma(input[i]), 1e-14);
    }

    /**
     * Test of reLnBn method, of class SpecialMath.
     */
    @Test
    public void testReLnBn()
    {
        System.out.println("reLnBn");
        int[] input = new int[]
        {
            0, 1, 2, 3, 4, 5, 6, 10, 40, 50, 70, 100
        };
        
        double[] expected = new double[]
        {
            0.,-0.6931471805599453,-1.791759469228055,Double.NEGATIVE_INFINITY,
            -3.401197381662155,Double.NEGATIVE_INFINITY,-3.737669618283368,
            -2.580216829592325,37.49870423894444,57.2770608118657,
            102.4807960976827,180.6448160951889
        };
        
        for(int i = 0; i < input.length; i++)
            assertEquals(expected[i], SpecialMath.reLnBn(input[i]), 1e-11);
    }

    /**
     * Test of bernoulli method, of class SpecialMath.
     */
    @Test
    public void testBernoulli()
    {
        System.out.println("bernoulli");
        int[] input = new int[]
        {
            0, 1, 2, 3, 4, 5, 6, 10, 14, 20
        };
        
        double[] expected = new double[]
        {
            1.,-0.5,0.1666666666666667,0.,-0.03333333333333333,0.,
            0.02380952380952381,0.07575757575757576,1.166666666666667,
            -529.1242424242425
        };
        
        for(int i = 0; i < input.length; i++)
            assertEquals(expected[i], SpecialMath.bernoulli(input[i]), 1e-11);
    }


}
