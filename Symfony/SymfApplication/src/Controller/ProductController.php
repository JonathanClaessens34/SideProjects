<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use App\Entity\Product;
use App\Form\ProductType;
// Include Dompdf required namespaces
use Dompdf\Dompdf;
use Dompdf\Options;

class

ProductController extends AbstractController
{

    public function _construct(ValidatorInterface $validator) {
        $this->validator = $validator;
    }

    /**
     * @Route("/welcome", name="welcome")
     */
    public function index(): Response
    {
        //$this->denyAccessUnlessGranted('IS_AUTHENTICATED_FULLY');
        return $this->render('welcome.html.twig');
    }

    /**
     * @Route("/product/allProducts", name="listproducts")
     */
    public function showAllTasks(): Response
    {
        $products = $this->getDoctrine()
                    ->getRepository(Product::class)
                    ->findAll();
        return $this->render('product/listproducts.html.twig', [
            'products' => $products,
        ]);
    }

    /**
     * @Route("/product/genAllProduct", name="genproducts")
     */
    public function genPdf()
    {
        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');
        
        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        
        // Retrieve the HTML generated in our twig file
        $products = $this->getDoctrine()
                    ->getRepository(Product::class)
                    ->findAll();
        $html = $this->renderView('product/listproducts.html.twig', [
            'products' => $products,
        ]);
        
        // Load HTML to Dompdf
        $dompdf->loadHtml($html);
        
        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (force download)
        $dompdf->stream("mypdf.pdf", [
            "Attachment" => true
        ]);
    }

    /**
     * @Route("/product/edit", name="edit_product")
     */
    public function editProduct(Request $request)
    {
        $id = $request->query->get('id');
        $em = $this->getDoctrine()->getManager();
        $product = $em->getRepository(Product::class)->find($id);
        if (!$product)
        {
        throw $this->createNotFoundException('No product found for id '.$id);
        }

        $form = $this->createForm(ProductType::class, $product);
        $form->handleRequest($request);
        if( $form->isSubmitted() && $form->isValid() ){
            $em = $this->getDoctrine()->getManager();
            $em->persist($product);
            $em->flush();
            $this->addFlash('coke', $product);
            return $this->redirectToRoute('addedproduct');
        }
        else{
            return $this->render( 'product/editproduct.html.twig',
            array('form' => $form->createView()));
        }
    }

    /**
     * @Route("/product/addedproduct", name="addedproduct")
     */
    public function showAddedProducts(Request $request){
        $products=$this->get('session')->getFlashBag()->get('coke');
        return $this->render('product/addedproduct.html.twig', [
            'products' => $products,
        ]);
    }

    /**
     * @Route("/product/delete", name="deleteproduct")
     */
    public function deleteProduct(Request $request) {
        $id = $request->query->get('id');
        $em = $this->getDoctrine()->getManager();
        $product = $em->getRepository(Product::class)->find($id);
        if(!$product) {
            throw $this->createNotFoundException("No product found for id: ", $id);
        }

        $em->remove($product);
        $em->flush();
        
        return $this->redirectToRoute('listproducts');
    }

    /**
     * @Route("/product/newproduct", name="addNewProduct")
     */
    public function addNewProduct(Request $request): Response
    {
        $task = new Product();
        $form = $this->createForm(ProductType::class, $task);
        $form->handleRequest($request);
        if( $form->isSubmitted() && $form->isValid() ){
            $em = $this->getDoctrine()->getManager();
            $em->persist($task);
            $em->flush();
            $this->addFlash('coke', $task);
            return $this->redirectToRoute('addedproduct');
        }
        else{
            return $this->render( 'product/editproduct.html.twig',
            array('form' => $form->createView()));
        }
    }

    /**
     * @Route("/product/search", name="searchProduct")
     */
    public function searchProduct(Request $request): Response
    {
        $name = $request->query->get('name');
        $products=$this->getDoctrine()
        ->getRepository(Product::class)
        ->findByTitle($name);
        return $this->render('product/listproducts.html.twig',[
            'products' => $products,
        ]);
    }
}
